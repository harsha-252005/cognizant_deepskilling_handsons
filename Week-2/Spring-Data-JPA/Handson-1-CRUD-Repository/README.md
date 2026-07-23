# Handson-1: Spring Data JPA — CRUD Repository

## Problem Statement
Implement full CRUD operations for a Product entity using Spring Data JPA's
JpaRepository, demonstrating derived query methods and custom JPQL queries.

## Objectives
- Map a Java class to a database table using JPA annotations
- Use JpaRepository for zero-boilerplate CRUD
- Write derived query methods (findByName, findByPriceLessThan)
- Write custom @Query with JPQL

## Concepts Used
| Concept | Detail |
|---|---|
| `@Entity` | Maps class to DB table |
| `@Id`, `@GeneratedValue` | Primary key configuration |
| `JpaRepository` | Provides save, findAll, findById, delete |
| Derived Queries | Method name → SQL auto-generated |
| `@Query` | Custom JPQL queries |
| H2 | In-memory database for testing |

## Project Structure
```
Handson-1-CRUD-Repository/
├── pom.xml
├── src/main/
│   ├── java/com/fse/jpa/
│   │   ├── entity/Product.java          ← TODO
│   │   ├── repository/ProductRepository.java  ← TODO
│   │   └── service/ProductService.java  ← TODO
│   └── resources/application.properties
└── README.md
```

## How to Build & Run
```bash
mvn clean install
mvn spring-boot:run
```

## Interview Questions
1. What is the difference between JpaRepository, CrudRepository, and PagingAndSortingRepository?
2. How does Spring Data JPA generate SQL from method names?
3. What is the difference between JPQL and SQL?
4. What does `@Transactional` do in a service method?
