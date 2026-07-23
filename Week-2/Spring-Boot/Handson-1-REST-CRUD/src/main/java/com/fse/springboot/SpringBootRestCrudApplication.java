package com.fse.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootRestCrudApplication — Entry point for the Spring Boot application.
 *
 * After startup:
 *   - REST API  : http://localhost:8080/api/employees
 *   - Swagger UI: http://localhost:8080/swagger-ui.html
 *   - H2 Console: http://localhost:8080/h2-console
 */
@SpringBootApplication
public class SpringBootRestCrudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestCrudApplication.class, args);
    }
}
