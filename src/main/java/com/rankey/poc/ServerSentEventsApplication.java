package com.rankey.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class ServerSentEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSentEventsApplication.class, args);
	}

}
