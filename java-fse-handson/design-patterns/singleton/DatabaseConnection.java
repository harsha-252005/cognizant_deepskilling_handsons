public class DatabaseConnection {

    // Eagerly created at class-load time — thread-safe without synchronization
    private static final DatabaseConnection INSTANCE = new DatabaseConnection();

    private int connectionCount = 0;

    // Private constructor prevents external instantiation
    private DatabaseConnection() {
        System.out.println("DatabaseConnection instance created.");
    }

    // Single global access point to the shared instance
    public static DatabaseConnection getInstance() {
        return INSTANCE;
    }

    public void connect() {
        connectionCount++;
        System.out.println("Connection established. Total connections: " + connectionCount);
    }
}
