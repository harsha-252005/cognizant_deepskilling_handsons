public class FactoryMethodDemo {
    public static void main(String[] args) {
        NotificationFactory[] factories = {
            new EmailNotificationFactory(),
            new SMSNotificationFactory(),
            new PushNotificationFactory()
        };

        for (NotificationFactory factory : factories) {
            factory.notify("Your order has been shipped!");
        }
    }
}
