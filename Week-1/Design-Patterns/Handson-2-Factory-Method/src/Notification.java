/**
 * Notification — Product Interface
 *
 * Defines the contract that all notification types must fulfill.
 * The Factory Method pattern works against this interface,
 * so the calling code never depends on concrete classes.
 */
public interface Notification {
    /**
     * Sends a notification with the given message.
     * @param message the content to deliver
     */
    void send(String message);
}
