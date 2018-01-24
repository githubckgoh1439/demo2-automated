package com.school.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GohSpringJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GohSpringJdbcApplication.class, args);
	}
}
