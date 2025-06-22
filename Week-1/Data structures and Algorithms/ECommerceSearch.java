import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {


    static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int id, String name, String category) {
            this.productId = id;
            this.productName = name;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "ID=" + productId +
                    ", Name='" + productName + '\'' +
                    ", Category='" + category + '\'' +
                    '}';
        }
    }


    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }


    public static Product binarySearch(Product[] products, String name) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));

        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(name);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Sneakers", "Footwear"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "T-shirt", "Clothing"),
            new Product(105, "Backpack", "Accessories")
        };

        String searchTerm = "Keyboard";

        System.out.println("=== Linear Search ===");
        Product result1 = linearSearch(products, searchTerm);
        System.out.println(result1 != null ? result1 : "Product not found");

        System.out.println("\n=== Binary Search ===");
        Product result2 = binarySearch(products, searchTerm);
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}

