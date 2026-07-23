/** Concrete Product — delivers via Push Notification. */
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("[Push] Sending message: " + message);
    }
}
