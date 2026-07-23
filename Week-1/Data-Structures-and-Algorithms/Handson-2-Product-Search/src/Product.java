/**
 * Product — Represents a single item in the e-commerce catalog.
 */
public class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final double price;

    public Product(String productId, String name, String category, double price) {
        this.productId = productId;
        this.name      = name;
        this.category  = category;
        this.price     = price;
    }

    public String getProductId() { return productId; }
    public String getName()      { return name; }
    public String getCategory()  { return category; }
    public double getPrice()     { return price; }

    @Override
    public String toString() {
        return "[" + productId + "] " + name + " - " + category + " - $" + price;
    }
}
