package com.example.dubbo.client;

import com.example.dubbo.api.model.User;
import com.example.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientApplicationTests {

	@Reference(interfaceName = "com.example.dubbo.api.model.User")
	private UserService userService;

	@Test
	void contextLoads() {

		User user = userService.findUserById(1);
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getTel());



	}

}
