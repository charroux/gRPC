package com.charroux.carstat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class CarstatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarstatApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			try {
				Server server = ServerBuilder
						.forPort(8080)
						.addService(new CarRentalServiceImpl()).build();
				server.start();
				System.out.println("ok");
				server.awaitTermination();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		};
	};

}
