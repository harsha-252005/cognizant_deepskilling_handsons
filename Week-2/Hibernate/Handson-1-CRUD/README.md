# Handson-1: Hibernate — CRUD Operations

## Problem Statement
Implement CRUD operations using Hibernate ORM directly (without Spring Data JPA)
to understand the underlying SessionFactory and Session API.

## Objectives
- Configure Hibernate with hibernate.cfg.xml
- Use Session, Transaction, and Query APIs
- Perform save, get, update, delete operations
- Understand HQL (Hibernate Query Language)

## Concepts Used
| Concept | Detail |
|---|---|
| `SessionFactory` | One per application, thread-safe |
| `Session` | One per request/transaction, not thread-safe |
| `Transaction` | Wraps DB operations |
| HQL | Object-oriented query language |
| `@Entity`, `@Table` | Hibernate mapping annotations |

## Project Structure
```
Handson-1-CRUD/
├── pom.xml
├── src/main/
│   ├── java/com/fse/hibernate/
│   │   ├── entity/Student.java       ← TODO
│   │   ├── util/HibernateUtil.java   ← TODO
│   │   └── StudentCRUDDemo.java      ← TODO
│   └── resources/hibernate.cfg.xml  ← TODO
└── README.md
```

## How to Build & Run
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.fse.hibernate.StudentCRUDDemo"
```

## Interview Questions
1. What is the difference between Hibernate and JPA?
2. What is the difference between get() and load() in Hibernate?
3. What are the states of a Hibernate entity (Transient, Persistent, Detached)?
4. What is the first-level cache in Hibernate?
