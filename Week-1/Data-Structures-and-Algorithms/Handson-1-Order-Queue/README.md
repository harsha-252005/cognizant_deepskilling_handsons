# Handson-1: Order Processing Queue — Priority Queue using LinkedList

## Problem Statement
Model an Amazon-style order processing system where EXPRESS orders are always
shipped before STANDARD orders, while preserving arrival order (FIFO) within
each priority tier.

## Objectives
- Understand Queue data structure and FIFO behavior
- Implement priority-based processing without a PriorityQueue
- Analyze time complexity of queue operations

## Concepts Used
| Concept | Detail |
|---|---|
| Queue (FIFO) | `java.util.Queue` backed by `LinkedList` |
| Dual-Queue Strategy | One queue per priority level |
| Enum | `Priority.EXPRESS` / `Priority.STANDARD` |
| Iterator | `forEach` to display without removing |

## Time & Space Complexity
| Operation | Time | Space |
|---|---|---|
| placeOrder | O(1) | O(1) |
| processNextOrder | O(1) | O(1) |
| peekNextOrder | O(1) | O(1) |
| displayAllPendingOrders | O(n) | O(1) |
| Overall space | — | O(n) |

## Project Structure
```
Handson-1-Order-Queue/
├── src/
│   ├── Priority.java     ← Enum
│   ├── Order.java        ← Model
│   ├── OrderQueue.java   ← Core logic
│   └── Main.java         ← Entry point
└── README.md
```

## How to Compile & Run
```bash
cd src
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

Next to process (peek): [EXPRESS] ORD-002 - Bob (Smartphone)

--- Pending Orders (4 total) ---
  [EXPRESS] ORD-002 - Bob (Smartphone)
  [EXPRESS] ORD-003 - Charlie (Headphones)
  [STANDARD] ORD-001 - Alice (Laptop)
  [STANDARD] ORD-004 - Diana (Keyboard)
-----------------------------------

=== Processing Orders ===
  Shipping 'Smartphone' to Bob | [EXPRESS] ORD-002 - Bob (Smartphone)
  Shipping 'Headphones' to Charlie | [EXPRESS] ORD-003 - Charlie (Headphones)
  Shipping 'Laptop' to Alice | [STANDARD] ORD-001 - Alice (Laptop)
  Shipping 'Keyboard' to Diana | [STANDARD] ORD-004 - Diana (Keyboard)

Queue empty, all orders shipped.
```

## Edge Cases
- Empty queue: `processNextOrder()` returns `null` — always check `isEmpty()` first.
- All EXPRESS: STANDARD queue stays empty, no issue.
- All STANDARD: EXPRESS queue stays empty, falls through to STANDARD.

## Interview Questions
1. Why use two queues instead of one `PriorityQueue`?
2. What is the difference between `poll()` and `remove()` in Java Queue?
3. What is the time complexity of `LinkedList` add/remove vs `ArrayDeque`?
4. How would you extend this to support 3 priority levels?

## Conclusion
Two dedicated queues give O(1) enqueue/dequeue while naturally preserving
FIFO within each priority — simpler and faster than a single sorted structure.
