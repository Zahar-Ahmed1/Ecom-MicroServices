package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class





CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(
					List.of(
							Customer.builder().name("ahmed").email("ahmed@gmail.com").build(),
							Customer.builder().name("zahr").email("zahar@gmail.com").build(),
							Customer.builder().name("ahmedzahar").email("ahmedzahar@gmail.com").build()
					)
			);
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
