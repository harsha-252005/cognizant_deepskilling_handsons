import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductCatalog — In-memory product store with multiple search strategies.
 *
 * Search Strategy Summary:
 * ┌─────────────────────┬───────────────────────────┬──────────────┐
 * │ Method              │ Algorithm                 │ Complexity   │
 * ├─────────────────────┼───────────────────────────┼──────────────┤
 * │ searchByName        │ Linear scan (partial)     │ O(n)         │
 * │ searchByCategory    │ Linear scan (exact)       │ O(n)         │
 * │ searchByPriceRange  │ Linear scan + sort result │ O(n log n)   │
 * │ binarySearchById    │ Sort copy + binary search │ O(n log n)   │
 * └─────────────────────┴───────────────────────────┴──────────────┘
 */
public class ProductCatalog {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Linear search O(n) — partial, case-insensitive name match.
     * Must scan every element; no index can help with arbitrary substrings.
     */
    public List<Product> searchByName(String keyword) {
        String lower = keyword.toLowerCase();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

    /**
     * Linear search O(n) — exact, case-insensitive category match.
     * Full scan required; list is not sorted by category.
     */
    public List<Product> searchByCategory(String category) {
        String lower = category.toLowerCase();
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(lower))
                .collect(Collectors.toList());
    }

    /**
     * Linear scan O(n) to filter, then sort O(n log n) on the result set.
     * Range queries cannot use binary search without a pre-sorted price index.
     * Results are returned sorted by price ascending.
     */
    public List<Product> searchByPriceRange(double minPrice, double maxPrice) {
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    /**
     * Binary Search O(log n) after sorting O(n log n).
     *
     * Why binary search is faster than linear search:
     * - Linear search: up to n comparisons (O(n))
     * - Binary search: at most log₂(n) comparisons (O(log n))
     * - For 1,000,000 products: linear = 1,000,000 steps vs binary = ~20 steps
     *
     * A copy of the list is sorted so the original insertion order is preserved
     * for other search methods.
     */
    public Product binarySearchById(String productId) {
        List<Product> sorted = new ArrayList<>(products);
        sorted.sort(Comparator.comparing(Product::getProductId));

        int low = 0, high = sorted.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = sorted.get(mid).getProductId().compareTo(productId);
            if (cmp == 0) return sorted.get(mid); // found — O(log n) reached
            if (cmp < 0)  low  = mid + 1;         // target in right half
            else          high = mid - 1;          // target in left half
        }
        return null; // not found
    }
}
