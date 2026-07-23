# Handson-1: Spring REST — Full CRUD API with Exception Handling & Swagger

## Problem Statement
Build a production-grade REST API for a Product catalog with full CRUD,
input validation, global exception handling, and Swagger documentation.

## Objectives
- Implement all HTTP methods with correct status codes
- Use ResponseEntity for flexible response control
- Apply @Valid for request body validation
- Handle exceptions globally with @RestControllerAdvice
- Generate Swagger UI with springdoc-openapi
- Create a Postman collection for testing

## Concepts Used
| Concept | Annotation |
|---|---|
| REST Controller | `@RestController` |
| HTTP Methods | `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` |
| Path Variables | `@PathVariable` |
| Request Body | `@RequestBody` |
| Validation | `@Valid`, `@NotBlank`, `@Min`, `@Max` |
| Exception Handling | `@RestControllerAdvice`, `@ExceptionHandler` |
| Response Control | `ResponseEntity<T>` |
| API Docs | `@Operation`, `@Tag` (springdoc) |

## Project Structure
```
Handson-1-CRUD-APIs/
├── pom.xml
├── src/main/java/com/fse/rest/
│   ├── controller/ProductController.java   ← TODO
│   ├── service/ProductService.java         ← TODO
│   ├── repository/ProductRepository.java   ← TODO
│   ├── entity/Product.java                 ← TODO
│   ├── dto/ProductDTO.java                 ← TODO
│   └── exception/
│       ├── ResourceNotFoundException.java  ← TODO
│       └── GlobalExceptionHandler.java     ← TODO
└── README.md
```

## API Endpoints
| Method | URL | Status |
|---|---|---|
| GET | /api/products | 200 OK |
| GET | /api/products/{id} | 200 / 404 |
| POST | /api/products | 201 Created |
| PUT | /api/products/{id} | 200 / 404 |
| DELETE | /api/products/{id} | 204 No Content |

## Interview Questions
1. What HTTP status codes should each CRUD operation return?
2. What is the difference between @RequestBody and @RequestParam?
3. How does @RestControllerAdvice differ from @ControllerAdvice?
4. What is content negotiation in Spring REST?
5. How do you version a REST API?
