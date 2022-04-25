package com.service.customer;

import com.service.customer.dto.CustomerRequestDTO;
import com.service.customer.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.save(new CustomerRequestDTO("C01", "MBA", "mbasonny@gmail.com"));
			customerService.save(new CustomerRequestDTO("C02", "Peyton", "peyton@gmail.com"));
		};
	}

}
