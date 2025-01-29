package com.redisNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisNotificationApplication.class, args);
		System.out.println("Redis cache is working");
	}

}
