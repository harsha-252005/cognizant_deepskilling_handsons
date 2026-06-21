public class SingletonDemo {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.connect();
        db2.connect();

        System.out.println("db1 == db2: " + (db1 == db2));
    }
}
