# Handson-2: Factory Method Pattern — Notification System

## Problem Statement
Build a notification system that can send messages via Email, SMS, or Push.
The calling code must never directly instantiate a concrete notification class —
it should only interact with the factory.

## Objectives
- Understand the Factory Method creational design pattern
- Apply the Open/Closed Principle
- Decouple object creation from object usage

## Concepts Used
| Concept | Detail |
|---|---|
| Factory Method | Subclasses decide which object to create |
| Abstract Class | `NotificationFactory` defines the template |
| Interface | `Notification` is the product contract |
| Open/Closed Principle | New channels need only a new subclass |
| Polymorphism | All factories used via `NotificationFactory` reference |

## Project Structure
```
Handson-2-Factory-Method/
├── src/
│   ├── Notification.java               ← Product interface
│   ├── EmailNotification.java          ← Concrete product
│   ├── SMSNotification.java            ← Concrete product
│   ├── PushNotification.java           ← Concrete product
│   ├── NotificationFactory.java        ← Abstract creator
│   ├── EmailNotificationFactory.java   ← Concrete creator
│   ├── SMSNotificationFactory.java     ← Concrete creator
│   ├── PushNotificationFactory.java    ← Concrete creator
│   └── FactoryMethodDemo.java          ← Entry point
└── README.md
```

## Step-by-Step Explanation
1. `Notification` interface defines `send(String message)` — the product contract.
2. `EmailNotification`, `SMSNotification`, `PushNotification` implement it with channel-specific logic.
3. `NotificationFactory` is abstract — it has the factory method `createNotification()` and the template method `notify()`.
4. Each concrete factory overrides `createNotification()` to return its product.
5. `main` iterates over factories and calls `notify()` — never touching concrete notification classes.

## How to Compile & Run
```bash
cd src
javac *.java
java FactoryMethodDemo
```

## Expected Output
```
=== Factory Method Pattern Demo ===

[Email] Sending message: Your order has been shipped!
[SMS] Sending message: Your order has been shipped!
[Push] Sending message: Your order has been shipped!
```

## Screenshots
> _Add output screenshot here after running._

## Interview Questions
1. What is the Factory Method pattern? How does it differ from Abstract Factory?
2. What problem does Factory Method solve that a simple `if-else` doesn't?
3. How does Factory Method support the Open/Closed Principle?
4. What is the role of the abstract creator class?
5. When would you choose Factory Method over a simple constructor?

## Viva Questions
1. Why is `NotificationFactory` abstract and not an interface?
2. What is the Template Method pattern and how is it used here?
3. Can you add a WhatsApp notification without changing existing classes?
4. What is the difference between a factory method and a static factory method?

## Conclusion
The Factory Method pattern cleanly separates "what to create" from "how to use it."
Adding a new notification channel requires only a new pair of classes — the rest
of the codebase remains untouched.
