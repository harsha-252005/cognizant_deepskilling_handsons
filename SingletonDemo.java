class DatabaseConnection {

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

public class SingletonDemo {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.connect();
        db2.connect();

        System.out.println("db1 == db2: " + (db1 == db2));
    }
}
