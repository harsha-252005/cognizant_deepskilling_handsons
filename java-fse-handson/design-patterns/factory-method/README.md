# Factory Method — Notification System

## What it demonstrates
The Factory Method pattern delegates object creation to subclasses.  
`NotificationFactory` defines the template (`notify()`); concrete factories (`EmailNotificationFactory`, etc.) decide which `Notification` implementation to instantiate.  
The calling code never uses `new` on a concrete notification class directly — it only talks to the factory.

## Files
| File | Role |
|---|---|
| `Notification.java` | Interface |
| `EmailNotification.java` | Concrete product |
| `SMSNotification.java` | Concrete product |
| `PushNotification.java` | Concrete product |
| `NotificationFactory.java` | Abstract creator |
| `EmailNotificationFactory.java` | Concrete creator |
| `SMSNotificationFactory.java` | Concrete creator |
| `PushNotificationFactory.java` | Concrete creator |
| `FactoryMethodDemo.java` | Entry point |

## Compile & Run
```bash
javac *.java
java FactoryMethodDemo
```

## Expected Output
```
Email sent: Your order has been shipped!
SMS sent: Your order has been shipped!
Push notification sent: Your order has been shipped!
```
