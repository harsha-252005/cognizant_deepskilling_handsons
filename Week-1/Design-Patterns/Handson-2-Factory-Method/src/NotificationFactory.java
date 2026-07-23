/**
 * NotificationFactory — Abstract Creator
 *
 * Defines the factory method createNotification() that subclasses override
 * to decide WHAT gets created. The notify() template method defines HOW
 * the created object is used — subclasses never touch this logic.
 *
 * Benefit: Adding a new channel (e.g., WhatsApp) requires only a new
 * subclass — zero changes to existing code (Open/Closed Principle).
 */
public abstract class NotificationFactory {

    /**
     * Factory Method — subclasses override this to return their product.
     * @return a Notification implementation
     */
    public abstract Notification createNotification();

    /**
     * Template method — orchestrates creation and usage.
     * Calling code only ever calls this; it never calls createNotification() directly.
     *
     * @param message the message to send
     */
    public void notify(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
