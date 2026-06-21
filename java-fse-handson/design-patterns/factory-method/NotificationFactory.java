// Each subclass decides WHAT to create; this class defines HOW it's used.
// Eliminates if-else/switch — new types only need a new factory subclass.
public abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void notify(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
