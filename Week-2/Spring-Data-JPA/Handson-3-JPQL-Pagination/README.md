# Handson-3: Spring Data JPA — JPQL, Pagination & Sorting

## Problem Statement
Implement custom JPQL queries, paginated results, and sorted queries
using Spring Data JPA's Pageable and Sort abstractions.

## Objectives
- Write JPQL with @Query
- Use Pageable for pagination
- Use Sort for dynamic ordering
- Implement search with LIKE in JPQL

## Concepts Used
| Concept | Detail |
|---|---|
| `@Query` | Custom JPQL / native SQL |
| `Pageable` | Page number, size, sort |
| `Page<T>` | Result with metadata (total pages, total elements) |
| `Sort` | Dynamic column sorting |

## Project Structure
```
Handson-3-JPQL-Pagination/
├── pom.xml
├── src/main/java/com/fse/jpa/
│   ├── entity/Product.java         ← TODO
│   ├── repository/ProductRepository.java  ← TODO
│   └── service/ProductService.java ← TODO
└── README.md
```

## Interview Questions
1. What is the difference between @Query with JPQL and nativeQuery=true?
2. How does Pageable work in Spring Data JPA?
3. What does Page<T> contain beyond the data?
4. How do you sort by multiple fields?
