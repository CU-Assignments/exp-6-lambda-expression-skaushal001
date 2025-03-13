import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.0),
            new Product("Smartphone", "Electronics", 800.0),
            new Product("Tablet", "Electronics", 500.0),
            new Product("Refrigerator", "Appliances", 1500.0),
            new Product("Microwave", "Appliances", 300.0),
            new Product("T-Shirt", "Clothing", 50.0),
            new Product("Jeans", "Clothing", 70.0)
        );

        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory, 
                Collectors.maxBy(Comparator.comparing(Product::getPrice))
            ));

        double avgPrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> 
            System.out.println(category + " -> " + productList));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + " -> " + product.orElse(null)));

        System.out.println("\nAverage price of all products: $" + avgPrice);
    }
}
