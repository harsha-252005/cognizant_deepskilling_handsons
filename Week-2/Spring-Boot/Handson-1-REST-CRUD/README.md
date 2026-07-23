# Handson-1: Spring Boot REST CRUD — Employee Management API

## Problem Statement
Build a fully functional REST API for Employee management with CRUD operations,
input validation, global exception handling, and Swagger documentation.

## Objectives
- Build a Spring Boot REST API from scratch
- Implement all HTTP methods: GET, POST, PUT, DELETE
- Apply Bean Validation (@Valid, @NotBlank, @Email)
- Handle exceptions globally with @RestControllerAdvice
- Document the API with Swagger/OpenAPI
- Write JUnit + Mockito unit tests

## Concepts Used
| Concept | Annotation / Class |
|---|---|
| REST Controller | `@RestController`, `@RequestMapping` |
| Dependency Injection | Constructor injection |
| JPA Entity | `@Entity`, `@Table`, `@Id` |
| Repository | `JpaRepository` |
| Validation | `@Valid`, `@NotBlank`, `@Email`, `@Min` |
| Exception Handling | `@RestControllerAdvice`, `@ExceptionHandler` |
| DTO Pattern | `EmployeeDTO` decouples API from entity |
| Swagger | `springdoc-openapi` |
| Unit Testing | JUnit 5 + Mockito |

## Project Structure
```
Handson-1-REST-CRUD/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/fse/springboot/
│   │   │   ├── SpringBootRestCrudApplication.java
│   │   │   ├── controller/EmployeeController.java
│   │   │   ├── service/EmployeeService.java
│   │   │   ├── repository/EmployeeRepository.java
│   │   │   ├── entity/Employee.java
│   │   │   ├── dto/EmployeeDTO.java
│   │   │   └── exception/
│   │   │       ├── ResourceNotFoundException.java
│   │   │       └── GlobalExceptionHandler.java
│   │   └── resources/application.properties
│   └── test/java/com/fse/springboot/
│       └── EmployeeServiceTest.java
└── README.md
```

## How to Build & Run
```bash
cd Handson-1-REST-CRUD
mvn clean install
mvn spring-boot:run
```

## API Endpoints
| Method | URL | Description |
|---|---|---|
| GET | /api/employees | Get all employees |
| GET | /api/employees/{id} | Get by ID |
| POST | /api/employees | Create employee |
| PUT | /api/employees/{id} | Update employee |
| DELETE | /api/employees/{id} | Delete employee |
| GET | /api/employees/dept/{dept} | Get by department |

## Sample Request (POST)
```json
{
  "firstName": "Alice",
  "lastName": "Smith",
  "email": "alice@company.com",
  "department": "Engineering",
  "salary": 85000
}
```

## URLs After Startup
- REST API   : http://localhost:8080/api/employees
- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 Console : http://localhost:8080/h2-console

## Screenshots
> _Add Swagger UI and Postman screenshots here._

## Interview Questions
1. What is the difference between @Controller and @RestController?
2. What does @RequestBody do? What about @PathVariable vs @RequestParam?
3. How does Spring Boot auto-configure the DataSource?
4. What is the DTO pattern and why use it?
5. How does @RestControllerAdvice work?
6. What is the difference between @Valid and @Validated?

## Viva Questions
1. What HTTP status code should a POST return on success?
2. What is ResponseEntity and why use it?
3. How does JpaRepository provide CRUD without implementation code?
4. What is the role of @Transactional?

## Conclusion
This exercise covers the full Spring Boot REST stack — from entity to controller —
with validation, exception handling, Swagger docs, and unit tests.
It is the foundation for all subsequent Spring-based exercises.
