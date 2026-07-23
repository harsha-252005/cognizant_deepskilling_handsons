/**
 * Order — Represents a customer order in the processing queue.
 */
public class Order {
    private final String orderId;
    private final String customerName;
    private final String product;
    private final Priority priority;

    public Order(String orderId, String customerName, String product, Priority priority) {
        this.orderId      = orderId;
        this.customerName = customerName;
        this.product      = product;
        this.priority     = priority;
    }

    public String getOrderId()      { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getProduct()      { return product; }
    public Priority getPriority()   { return priority; }

    @Override
    public String toString() {
        return "[" + priority + "] " + orderId + " - " + customerName + " (" + product + ")";
    }
}
