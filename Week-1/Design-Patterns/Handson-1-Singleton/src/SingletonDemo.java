/**
 * SingletonDemo — Entry Point
 *
 * Demonstrates that db1 and db2 are the exact same object in memory,
 * and that connectionCount is shared state across both references.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demo ===\n");

        // Both variables receive the same pre-created instance.
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.connect(); // connectionCount → 1
        db2.connect(); // connectionCount → 2 (same object, shared state)

        // Reference equality proves it's the same object.
        System.out.println("\ndb1 == db2 : " + (db1 == db2));
        System.out.println("Total connections via db1: " + db1.getConnectionCount());
        System.out.println("Total connections via db2: " + db2.getConnectionCount());
    }
}
