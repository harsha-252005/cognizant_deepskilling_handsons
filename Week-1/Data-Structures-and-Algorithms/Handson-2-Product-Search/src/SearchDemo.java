import java.util.List;

/**
 * SearchDemo — Demonstrates all four search strategies on a product catalog.
 */
public class SearchDemo {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct(new Product("P001", "Wireless Mouse",      "Electronics", 29.99));
        catalog.addProduct(new Product("P002", "Mechanical Keyboard", "Electronics", 79.99));
        catalog.addProduct(new Product("P003", "Running Shoes",       "Footwear",    59.99));
        catalog.addProduct(new Product("P004", "Yoga Mat",            "Sports",      24.99));
        catalog.addProduct(new Product("P005", "Bluetooth Speaker",   "Electronics", 49.99));
        catalog.addProduct(new Product("P006", "Trail Running Shoes", "Footwear",    89.99));

        System.out.println("=== Search by Name: 'running' ===");
        printResults(catalog.searchByName("running"));

        System.out.println("\n=== Search by Category: 'Electronics' ===");
        printResults(catalog.searchByCategory("Electronics"));

        System.out.println("\n=== Search by Price Range: $25.00 - $70.00 ===");
        printResults(catalog.searchByPriceRange(25.00, 70.00));

        System.out.println("\n=== Binary Search by ID: 'P004' (valid) ===");
        Product found = catalog.binarySearchById("P004");
        System.out.println(found != null ? "  Found    : " + found : "  Product not found.");

        System.out.println("\n=== Binary Search by ID: 'P999' (invalid) ===");
        Product notFound = catalog.binarySearchById("P999");
        System.out.println(notFound != null ? "  Found    : " + notFound : "  Product not found.");
    }

    private static void printResults(List<Product> results) {
        if (results.isEmpty()) {
            System.out.println("  No products found.");
        } else {
            results.forEach(p -> System.out.println("  " + p));
        }
    }
}
