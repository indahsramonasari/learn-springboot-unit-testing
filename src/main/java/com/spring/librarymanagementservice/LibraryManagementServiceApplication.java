package com.spring.librarymanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring.librarymanagementservice.*")
public class LibraryManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementServiceApplication.class, args);
	}

}
