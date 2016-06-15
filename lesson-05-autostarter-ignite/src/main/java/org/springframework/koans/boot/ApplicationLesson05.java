package org.springframework.koans.boot;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationLesson05 {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(ApplicationLesson05.class, args);

	}
}
