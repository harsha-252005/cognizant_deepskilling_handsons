/**
 * FactoryMethodDemo — Entry Point
 *
 * The main method only talks to NotificationFactory.
 * It never calls new EmailNotification(), new SMSNotification(), etc.
 * This is the core promise of the Factory Method pattern.
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");

        NotificationFactory[] factories = {
            new EmailNotificationFactory(),
            new SMSNotificationFactory(),
            new PushNotificationFactory()
        };

        String message = "Your order has been shipped!";
        for (NotificationFactory factory : factories) {
            factory.notify(message);
        }
    }
}
