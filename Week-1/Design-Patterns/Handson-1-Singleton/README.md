# Handson-1: Singleton Pattern — Shared Database Connection

## Problem Statement
Design a `DatabaseConnection` class that guarantees only one instance exists
throughout the application, simulating a shared database connection pool.

## Objectives
- Understand the Singleton creational design pattern
- Implement eager initialization
- Prove single-instance behavior using reference equality

## Concepts Used
| Concept | Detail |
|---|---|
| Singleton Pattern | One instance, global access point |
| Eager Initialization | Instance created at class-load time |
| Thread Safety | JVM class-loading is inherently thread-safe |
| Private Constructor | Prevents external instantiation |
| Static Factory Method | `getInstance()` returns the shared instance |

## Project Structure
```
Handson-1-Singleton/
├── src/
│   ├── DatabaseConnection.java   ← Singleton class
│   └── SingletonDemo.java        ← Entry point
└── README.md
```

## Step-by-Step Explanation
1. `DatabaseConnection` declares a `private static final` field initialized directly — this is eager initialization.
2. The `private` constructor blocks any `new DatabaseConnection()` calls from outside.
3. `getInstance()` simply returns the already-created `INSTANCE`.
4. `connect()` increments a shared `connectionCount` — both `db1` and `db2` see the same counter because they point to the same object.
5. `db1 == db2` evaluates to `true` — reference equality confirms one object.

## How to Compile & Run
```bash
cd src
javac *.java
java SingletonDemo
```

## Expected Output
```
=== Singleton Pattern Demo ===

[Singleton] DatabaseConnection instance created.
[Singleton] Connection established. Total connections: 1
[Singleton] Connection established. Total connections: 2

db1 == db2 : true
Total connections via db1: 2
Total connections via db2: 2
```

## Screenshots
> _Add output screenshot here after running._

## Interview Questions
1. What is the Singleton pattern and when should you use it?
2. What is the difference between eager and lazy initialization?
3. How do you make a Singleton thread-safe without `synchronized`?
4. Can Singleton be broken using Reflection? How do you prevent it?
5. What is double-checked locking?

## Viva Questions
1. Why is the constructor `private`?
2. Why is `INSTANCE` declared `static final`?
3. What happens if two threads call `getInstance()` simultaneously in a lazy singleton?
4. How does eager initialization solve the thread-safety problem?

## Conclusion
Eager initialization is the simplest and most reliable Singleton strategy.
It trades a tiny amount of memory (instance always exists) for guaranteed
thread-safety and zero synchronization overhead.
