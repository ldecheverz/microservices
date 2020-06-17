package com.globallogic.people.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableResourceServer
@EnableFeignClients("com.globallogic.people.management")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
