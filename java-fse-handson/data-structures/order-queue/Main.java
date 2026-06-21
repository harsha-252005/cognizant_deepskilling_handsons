public class Main {
    public static void main(String[] args) {
        OrderQueue queue = new OrderQueue();

        System.out.println("=== Placing Orders ===");
        queue.placeOrder(new Order("ORD-001", "Alice",   "Laptop",     Priority.STANDARD));
        queue.placeOrder(new Order("ORD-002", "Bob",     "Smartphone", Priority.EXPRESS));
        queue.placeOrder(new Order("ORD-003", "Charlie", "Headphones", Priority.EXPRESS));
        queue.placeOrder(new Order("ORD-004", "Diana",   "Keyboard",   Priority.STANDARD));

        queue.displayAllPendingOrders();

        System.out.println("\n=== Processing Orders ===");
        while (!queue.isEmpty()) {
            Order order = queue.processNextOrder();
            System.out.println("Shipping " + order.getProduct() + " to " + order.getCustomerName()
                    + " | " + order);
        }

        System.out.println("\nQueue empty, all orders shipped.");
    }
}
