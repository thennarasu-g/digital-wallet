package com.digital.wallet.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAsync
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}
