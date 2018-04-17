package org.springframework.koans.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationLesson01 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLesson01.class, args);
		System.out.println("test");
	}
}
