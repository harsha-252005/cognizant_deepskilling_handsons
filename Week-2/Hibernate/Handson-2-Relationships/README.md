# Handson-2: Hibernate — Entity Relationships

## Problem Statement
Map and persist One-to-One, One-to-Many, and Many-to-Many relationships
using Hibernate annotations and verify with HQL queries.

## Objectives
- Map all relationship types with Hibernate
- Configure cascade and fetch strategies
- Use HQL to query across relationships
- Understand bidirectional vs unidirectional mappings

## Project Structure
```
Handson-2-Relationships/
├── pom.xml
├── src/main/java/com/fse/hibernate/
│   ├── entity/
│   │   ├── Author.java    ← TODO
│   │   ├── Book.java      ← TODO
│   │   └── Category.java  ← TODO
│   └── RelationshipDemo.java ← TODO
└── README.md
```

## Interview Questions
1. What is the difference between @OneToMany(mappedBy) and @JoinColumn?
2. How do you prevent infinite recursion in bidirectional relationships?
3. What is orphanRemoval and when do you use it?
