# Handson-2: Spring Data JPA — Entity Relationships

## Problem Statement
Model and persist entity relationships (One-to-One, One-to-Many, Many-to-Many)
using JPA annotations and verify them with Spring Data repositories.

## Objectives
- Implement @OneToOne, @OneToMany, @ManyToOne, @ManyToMany
- Understand owning side vs inverse side
- Configure cascade types and fetch strategies
- Avoid N+1 query problems

## Concepts Used
| Annotation | Relationship |
|---|---|
| `@OneToOne` | Employee ↔ Address |
| `@OneToMany` / `@ManyToOne` | Department ↔ Employees |
| `@ManyToMany` | Student ↔ Courses |
| `@JoinColumn` | Foreign key column |
| `@JoinTable` | Junction table for M:N |
| `FetchType.LAZY` | Load related data on demand |

## Project Structure
```
Handson-2-Relationships/
├── pom.xml
├── src/main/java/com/fse/jpa/entity/
│   ├── Department.java    ← TODO
│   ├── Employee.java      ← TODO
│   ├── Address.java       ← TODO
│   ├── Student.java       ← TODO
│   └── Course.java        ← TODO
└── README.md
```

## Interview Questions
1. What is the difference between CascadeType.ALL and CascadeType.MERGE?
2. What is the N+1 problem and how do you solve it?
3. What is the difference between EAGER and LAZY fetching?
4. Which side owns the relationship in @ManyToMany?
