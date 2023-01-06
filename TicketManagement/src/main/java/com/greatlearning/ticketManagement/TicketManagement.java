package com.greatlearning.ticketManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.greatlearning.ticketManagement.service.TicketServiceImpl;

@SpringBootApplication
public class TicketManagement implements CommandLineRunner {

	@Autowired
	TicketServiceImpl ticketServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(TicketManagement.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
