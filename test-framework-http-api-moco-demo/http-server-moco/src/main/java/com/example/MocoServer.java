package com.example;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runner;
import static com.github.dreamhead.moco.Runner.runner;
import static com.github.dreamhead.moco.Moco.file;
import static com.github.dreamhead.moco.MocoJsonRunner.jsonHttpServer;


public class MocoServer   {

    public static void main(String[] args) {
        Runner runner;
        final HttpServer server = jsonHttpServer(12306, file(System.getProperty("user.dir") + "/moco_config.json"));
        runner = runner(server);
        runner.start();
        System.out.println("Moco Server start ... ");
    }

}
