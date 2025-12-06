package com.gimnasio.servicio_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicioCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCustomerApplication.class, args);
	}

}
