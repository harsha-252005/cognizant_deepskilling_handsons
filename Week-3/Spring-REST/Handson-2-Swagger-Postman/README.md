# Handson-2: Spring REST — Swagger UI & Postman Collection

## Problem Statement
Document an existing REST API using springdoc-openapi (Swagger UI)
and create a Postman collection for all endpoints.

## Objectives
- Configure springdoc-openapi in a Spring Boot project
- Annotate controllers with @Operation, @Tag, @ApiResponse
- Export and import a Postman collection
- Test all endpoints via Swagger UI and Postman

## Swagger Annotations
| Annotation | Purpose |
|---|---|
| `@Tag` | Groups endpoints under a label |
| `@Operation` | Describes a single endpoint |
| `@ApiResponse` | Documents possible responses |
| `@Parameter` | Describes a path/query parameter |
| `@Schema` | Describes a model/DTO |

## Swagger UI URL
```
http://localhost:8080/swagger-ui.html
```

## Postman Collection
> Import `postman_collection.json` from this folder into Postman.

## Interview Questions
1. What is OpenAPI Specification (OAS)?
2. What is the difference between Swagger 2 and OpenAPI 3?
3. How do you secure Swagger UI in production?
4. What is the difference between springfox and springdoc?
