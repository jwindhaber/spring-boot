package org.springframework.koans.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.koans.boot.config.persistence.PersistenceConfiguration;

@SpringBootApplication
@Import(PersistenceConfiguration.class)
public class ApplicationLesson02 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationLesson02.class, args);
    }
}
