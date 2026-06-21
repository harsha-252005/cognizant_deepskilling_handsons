import java.util.LinkedList;
import java.util.Queue;

// Two separate queues ensure EXPRESS orders are always drained first
// while preserving FIFO order within each priority level.
public class OrderQueue {
    private final Queue<Order> expressQueue  = new LinkedList<>();
    private final Queue<Order> standardQueue = new LinkedList<>();

    public void placeOrder(Order order) {
        if (order.getPriority() == Priority.EXPRESS) {
            expressQueue.add(order);
        } else {
            standardQueue.add(order);
        }
        System.out.println("Order placed: " + order);
    }

    public Order processNextOrder() {
        return expressQueue.isEmpty() ? standardQueue.poll() : expressQueue.poll();
    }

    public Order peekNextOrder() {
        return expressQueue.isEmpty() ? standardQueue.peek() : expressQueue.peek();
    }

    public boolean isEmpty() {
        return expressQueue.isEmpty() && standardQueue.isEmpty();
    }

    public int getQueueSize() {
        return expressQueue.size() + standardQueue.size();
    }

    public void displayAllPendingOrders() {
        System.out.println("\n--- Pending Orders (" + getQueueSize() + " total) ---");
        expressQueue.forEach(o  -> System.out.println("  " + o));
        standardQueue.forEach(o -> System.out.println("  " + o));
        System.out.println("-----------------------------------");
    }
}
