package com.gmart.api.chat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ChatWebSocketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatWebSocketsApplication.class, args);
	}

}