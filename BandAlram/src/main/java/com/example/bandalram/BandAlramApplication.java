package com.example.bandalram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
public class BandAlramApplication {

	public static void main(String[] args) {
		SpringApplication.run(BandAlramApplication.class, args);
	}

}
