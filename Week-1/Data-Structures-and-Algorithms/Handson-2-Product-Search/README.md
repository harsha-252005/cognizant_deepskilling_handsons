# Handson-2: Product Catalog Search — Linear vs Binary Search

## Problem Statement
Implement a search engine for an e-commerce product catalog that supports
name search, category filter, price range filter, and fast ID lookup using
binary search.

## Objectives
- Implement and compare linear search vs binary search
- Understand when each algorithm is appropriate
- Analyze time and space complexity

## Concepts Used
| Concept | Detail |
|---|---|
| Linear Search | O(n) — required for partial/range queries |
| Binary Search | O(log n) — fast exact lookup on sorted data |
| Java Streams | Functional-style filtering and sorting |
| Comparator | Custom sort for binary search and price range |
| ArrayList | Dynamic array backing the catalog |

## Time & Space Complexity
| Method | Algorithm | Time | Space |
|---|---|---|---|
| searchByName | Linear scan | O(n) | O(k) result |
| searchByCategory | Linear scan | O(n) | O(k) result |
| searchByPriceRange | Scan + sort | O(n log n) | O(k) result |
| binarySearchById | Sort + binary | O(n log n) | O(n) copy |

> k = number of matching results

## Project Structure
```
Handson-2-Product-Search/
├── src/
│   ├── Product.java          ← Model
│   ├── ProductCatalog.java   ← Search logic
│   └── SearchDemo.java       ← Entry point
└── README.md
```

## How to Compile & Run
```bash
cd src
javac *.java
java SearchDemo
```

## Expected Output
```
=== Search by Name: 'running' ===
  [P003] Running Shoes - Footwear - $59.99
  [P006] Trail Running Shoes - Footwear - $89.99

=== Search by Category: 'Electronics' ===
  [P001] Wireless Mouse - Electronics - $29.99
  [P002] Mechanical Keyboard - Electronics - $79.99
  [P005] Bluetooth Speaker - Electronics - $49.99

=== Search by Price Range: $25.00 - $70.00 ===
  [P001] Wireless Mouse - Electronics - $29.99
  [P005] Bluetooth Speaker - Electronics - $49.99
  [P003] Running Shoes - Footwear - $59.99

=== Binary Search by ID: 'P004' (valid) ===
  Found    : [P004] Yoga Mat - Sports - $24.99

=== Binary Search by ID: 'P999' (invalid) ===
  Product not found.
```

## Edge Cases
- Empty catalog: all methods return empty list or null safely.
- Case sensitivity: all string comparisons are case-insensitive.
- Invalid ID: binary search returns null — caller must null-check.

## Interview Questions
1. Why can't binary search be used for partial name matching?
2. What precondition must be met before binary search can run?
3. What is the difference between O(n) and O(log n) in practical terms?
4. How would you make `binarySearchById` more efficient for repeated calls?
5. What Java collection would give O(1) lookup by ID?

## Practice Problems
1. Add a `searchByPriceRange` that also filters by category.
2. Implement a `HashMap<String, Product>` index for O(1) ID lookup.
3. Sort results by name alphabetically in `searchByCategory`.

## Conclusion
Binary search is dramatically faster than linear search for exact lookups on
sorted data. For 1M products, binary search needs ~20 comparisons vs up to
1,000,000 for linear search. The trade-off is the O(n log n) sort prerequisite.
