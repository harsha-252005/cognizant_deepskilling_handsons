import java.util.LinkedList;
import java.util.Queue;

/**
 * OrderQueue — Priority-aware order processing queue.
 *
 * Data Structure: Two java.util.Queue<Order> (LinkedList implementation)
 *
 * Why two queues instead of one sorted queue?
 * - O(1) enqueue and dequeue for both priority levels.
 * - FIFO is naturally preserved within each tier.
 * - No sorting, no comparators, no re-ordering on insert.
 * - A single PriorityQueue would give O(log n) insert and lose stable FIFO ordering.
 *
 * Time Complexity:
 *   placeOrder        → O(1)
 *   processNextOrder  → O(1)
 *   peekNextOrder     → O(1)
 *   getQueueSize      → O(1)
 *   displayAllPending → O(n)
 */
public class OrderQueue {

    private final Queue<Order> expressQueue  = new LinkedList<>();
    private final Queue<Order> standardQueue = new LinkedList<>();

    /** Adds the order to the correct internal queue. */
    public void placeOrder(Order order) {
        if (order.getPriority() == Priority.EXPRESS) {
            expressQueue.add(order);
        } else {
            standardQueue.add(order);
        }
        System.out.println("  Order placed: " + order);
    }

    /**
     * Removes and returns the next order to process.
     * EXPRESS queue is always drained before STANDARD.
     */
    public Order processNextOrder() {
        return expressQueue.isEmpty() ? standardQueue.poll() : expressQueue.poll();
    }

    /** Views the next order without removing it. */
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
