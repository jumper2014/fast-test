package org.example.helloworld;
/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.delegatesTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcCleanupRule;
//import org.junit.Before;
import io.qameta.allure.*;
import org.junit.BeforeClass;
import org.junit.Rule;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;

import java.io.IOException;

/**
 * Unit tests for {@link HelloWorldClient}.
 * For demonstrating how to write gRPC unit test only.
 * Not intended to provide a high code coverage or to test every major usecase.
 *
 * directExecutor() makes it easier to have deterministic tests.
 *
 */
@Epic("Epic for Automation framework")
@Feature("Feature for JUnit")
public class HelloWorldClientTest {
    /**
     * This rule manages automatic graceful shutdown for the registered servers and channels at the
     * end of test.
     */
    @Rule
    public static final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

    private static final GreeterGrpc.GreeterImplBase serviceImpl =
            mock(GreeterGrpc.GreeterImplBase.class, delegatesTo(
                    new GreeterGrpc.GreeterImplBase() {
                        // By default the client will receive Status.UNIMPLEMENTED for all RPCs.
                        // You might need to implement necessary behaviors for your test here, like this:
                        //
                         @Override
                         public void sayHello(HelloRequest request, StreamObserver<HelloReply> respObserver) {
                           respObserver.onNext(HelloReply.getDefaultInstance());
                           respObserver.onCompleted();
                         }
                    }));

    private static HelloWorldClient client;

    @BeforeAll
    public static void setUp() throws IOException {
        // Generate a unique in-process server name.
        String serverName = InProcessServerBuilder.generateName();

        // Create a server, add service, start, and register for automatic graceful shutdown.
        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(serviceImpl).build().start());

        // Create a client channel and register for automatic graceful shutdown.
        ManagedChannel channel = grpcCleanup.register(
                InProcessChannelBuilder.forName(serverName).directExecutor().build());

        // Create a HelloWorldClient using the in-process channel;
        client = new HelloWorldClient(channel);
    }

    /**
     * To test the client, call from the client against the fake server, and verify behaviors or state
     * changes from the server side.
     */
    @DisplayName("Test GRPC Client")
    @Issue("bug0002")
    @Story("Story0002")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name="静态链接sample", url="https://www.baidu.com")
    @Description("验证grpc client正确发送响应")
    @Test
    public void greet_messageDeliveredToServer() {
        ArgumentCaptor<HelloRequest> requestCaptor = ArgumentCaptor.forClass(HelloRequest.class);
        client.greet("test name");
        verify(serviceImpl)
                .sayHello(requestCaptor.capture(), ArgumentMatchers.<StreamObserver<HelloReply>>any());
        assertEquals("test name", requestCaptor.getValue().getName());
    }
}
