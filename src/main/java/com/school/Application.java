package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Exclude DataSourceAutoConfiguration for now so Spring Boot doesn't
// attempt to auto-wire a database connection before we tell it to.
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.school")
@EntityScan(basePackages = "com.school")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}