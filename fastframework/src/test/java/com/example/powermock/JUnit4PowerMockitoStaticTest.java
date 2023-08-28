package com.example.powermock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

import com.example.app.powermock.HelperUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HelperUtils.class)
public class JUnit4PowerMockitoStaticTest{

    @Test
    public void test_static_mock_methods() {
        PowerMockito.mockStatic(HelperUtils.class);
        when(HelperUtils.print("Hello")).thenReturn(true);
        when(HelperUtils.print("Wrong Message")).thenReturn(false);

        assertTrue(HelperUtils.print("Hello"));
        assertFalse(HelperUtils.print("Wrong Message"));

        PowerMockito.verifyStatic(HelperUtils.class, atLeast(2));
        HelperUtils.print(anyString());
    }

    @Test
    public void testPrivateMethodCaller() throws Exception {
        HelperUtils helperUtils = new HelperUtils();
        HelperUtils mock = PowerMockito.spy(helperUtils);
        PowerMockito.when(mock, "getPrivateMethod").thenReturn("Hello from the Private Method.!");
        String resultFromThePrivateMethodCaller = mock.privateMethodCaller();
        verifyPrivate(mock).invoke("getPrivateMethod");
        assertEquals("Hello from the Private Method! Welcome to the Application Developer's Blog", resultFromThePrivateMethodCaller);
    }

    @Test
    public void testGetFinalMethod() {
        HelperUtils helperUtils = new HelperUtils();
        HelperUtils mock = PowerMockito.spy(helperUtils);
        PowerMockito.when(mock.getFinalMethod()).thenReturn("Hello from the Final Method!");
        String resultFromTheFinalMethod = mock.getFinalMethod();
        verify(mock).getFinalMethod();
        assertEquals("Hello from the Final Method!", resultFromTheFinalMethod);
    }
}
