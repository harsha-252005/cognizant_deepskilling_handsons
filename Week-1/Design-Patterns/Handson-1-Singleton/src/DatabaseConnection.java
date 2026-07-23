/**
 * Singleton Pattern — DatabaseConnection
 *
 * Ensures only one instance of the database connection exists
 * across the entire application lifecycle.
 *
 * Strategy: Eager Initialization
 * - Instance is created when the class is loaded by the JVM.
 * - Thread-safe without synchronized blocks.
 * - Suitable when the instance is always needed and creation is lightweight.
 */
public class DatabaseConnection {

    // Eagerly created at class-load time — JVM guarantees thread-safety here.
    private static final DatabaseConnection INSTANCE = new DatabaseConnection();

    private int connectionCount = 0;

    // Private constructor prevents any external class from calling new DatabaseConnection().
    private DatabaseConnection() {
        System.out.println("[Singleton] DatabaseConnection instance created.");
    }

    /**
     * The single global access point.
     * Always returns the same pre-created instance.
     *
     * @return the sole DatabaseConnection instance
     */
    public static DatabaseConnection getInstance() {
        return INSTANCE;
    }

    /**
     * Simulates opening a connection.
     * Increments and reports the running total of connections made.
     */
    public void connect() {
        connectionCount++;
        System.out.println("[Singleton] Connection established. Total connections: " + connectionCount);
    }

    public int getConnectionCount() {
        return connectionCount;
    }
}
