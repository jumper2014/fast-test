package com.zyt.dubbo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@ComponentScan(basePackages = "com.zyt.dubbo.server")
@SpringBootApplication
public class ServerApplication {

	@lombok.SneakyThrows
	public static void main(String[] args) {

		ConfigurableApplicationContext application= SpringApplication.run(ServerApplication.class, args);
		Environment env = application.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		String active = env.getProperty("spring.profiles.active");
		String port = env.getProperty("server.port");
		port = port == null ? "8080" : port;
		String path = env.getProperty("server.servlet.context-path");
		path = path == null ? "" : path;
		System.out.println("\n----------------------------------------------------------\n\t" +
				"aut-server is running! \n\t" +
				"系统运行环境 : \t" +active + "\n\t" +
				"本地访问地址 : \thttp://localhost:" + port + path + "/\n\t" +
				"外部访问地址 : \thttp://" + ip + ":" + port + path + "/\n\t" +
				"在线文档地址 : \thttp://" + ip + ":" + port + path + "/swagger-ui/index.html\n" +
				"----------------------------------------------------------");
	}

}
