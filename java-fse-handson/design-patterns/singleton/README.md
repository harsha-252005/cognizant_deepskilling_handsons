# Singleton — Shared Database Connection

## What it demonstrates
The Singleton pattern ensures only one instance of `DatabaseConnection` exists across the entire application.  
Uses **eager initialization** (instance created at class-load time), which is inherently thread-safe without `synchronized` blocks.

## Files
| File | Role |
|---|---|
| `DatabaseConnection.java` | Singleton class |
| `SingletonDemo.java` | Entry point |

## Compile & Run
```bash
javac *.java
java SingletonDemo
```

## Expected Output
```
DatabaseConnection instance created.
Connection established. Total connections: 1
Connection established. Total connections: 2
db1 == db2: true
```
