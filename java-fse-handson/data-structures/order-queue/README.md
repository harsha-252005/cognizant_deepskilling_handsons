# Order Queue — Priority-Aware Processing

## What it demonstrates
Models an Amazon-style order processing queue using two internal `java.util.Queue` (LinkedList) instances — one for EXPRESS and one for STANDARD orders.  
EXPRESS orders are always fully drained before STANDARD ones, while FIFO order is preserved within each priority tier.

## Files
| File | Role |
|---|---|
| `Priority.java` | Enum (STANDARD, EXPRESS) |
| `Order.java` | Order model |
| `OrderQueue.java` | Dual-queue manager |
| `Main.java` | Entry point |

## Compile & Run
```bash
javac *.java
java Main
```

## Expected Output
```
=== Placing Orders ===
Order placed: [STANDARD] ORD-001 - Alice (Laptop)
Order placed: [EXPRESS] ORD-002 - Bob (Smartphone)
Order placed: [EXPRESS] ORD-003 - Charlie (Headphones)
Order placed: [STANDARD] ORD-004 - Diana (Keyboard)

--- Pending Orders (4 total) ---
  [EXPRESS] ORD-002 - Bob (Smartphone)
  [EXPRESS] ORD-003 - Charlie (Headphones)
  [STANDARD] ORD-001 - Alice (Laptop)
  [STANDARD] ORD-004 - Diana (Keyboard)
-----------------------------------

=== Processing Orders ===
Shipping Smartphone to Bob | [EXPRESS] ORD-002 - Bob (Smartphone)
Shipping Headphones to Charlie | [EXPRESS] ORD-003 - Charlie (Headphones)
Shipping Laptop to Alice | [STANDARD] ORD-001 - Alice (Laptop)
Shipping Keyboard to Diana | [STANDARD] ORD-004 - Diana (Keyboard)

Queue empty, all orders shipped.
```
