package net.ktc.customer;

import net.ktc.customer.dto.CustomerRequestDTO;
import net.ktc.customer.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}

/*@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.save(new CustomerRequestDTO("01","test","+237 675877758", "69857458","test@test.com","www.local.net","Yde","CM", "Biyem-assi","bien"));
			customerService.save(new CustomerRequestDTO("02","test2","+237 675877757", "69874568","test1@test.com","www.local.com","Paris","FR", "Bolore","mal"));
		};
	}

}*/
