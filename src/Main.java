import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create sample product catalog.
        List<Product> productCatalog = new ArrayList<>();
        productCatalog.add(new Electronics(1, "Laptop HP", 1200.00, 15, 24));
        productCatalog.add(new Electronics(2, "Smartphone Iphone", 799.00, 25, 12));
        productCatalog.add(new Clothing(3, "T-Shirt Polo", 20.00, 100, "M", "Cotton"));
        productCatalog.add(new Clothing(4, "Jeans BlueAge", 40.00, 50, "L", "Denim"));

        // Java Collections for orders and user order history.
        ArrayList<Order> Orders = new ArrayList<>();
        HashMap<Integer, ArrayList<Order>> userOrderHistory = new HashMap<>();

        int orderIdCounter = 1;
        int orderDetailIdCounter = 1;

        // Simple CLI Menu.
        while (true) {
            System.out.println("\n--- E-Commerce CLI Menu ---");
            System.out.println("1. Place Order");
            System.out.println("2. View Order History");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Enter User ID: ");
                int userId = scanner.nextInt();
                Order order = new Order(orderIdCounter++, userId);

                // Display product catalog.
                System.out.println("\nProduct Catalog:");
                for (Product p : productCatalog) {
                    System.out.println(p);
                }

                System.out.print("Enter Product ID to order: ");
                int productId = scanner.nextInt();
                Product selectedProduct = null;
                for (Product p : productCatalog) {
                    if (p.getProductId() == productId) {
                        selectedProduct = p;
                        break;
                    }
                }
                if (selectedProduct == null) {
                    System.out.println("Invalid Product ID!");
                    continue;
                }

                System.out.print("Enter Quantity: ");
                int quantity = scanner.nextInt();

                try {
                    // Attempt to reduce stock; may throw an OutOfStockException.
                    selectedProduct.reduceStock(quantity);

                    // Create and add OrderDetails.
                    OrderDetails od = new OrderDetails(orderDetailIdCounter++, order.getOrderId(), selectedProduct, quantity);
                    order.addOrderDetails(od);

                    // Save order in collections.
                    Orders.add(order);
                    userOrderHistory.putIfAbsent(userId, new ArrayList<>());
                    userOrderHistory.get(userId).add(order);

                    System.out.println("\nOrder placed successfully!");
                    System.out.println(order);
                } catch (OutOfStockException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (option == 2) {
                System.out.print("Enter User ID to view order history: ");
                int userId = scanner.nextInt();
                ArrayList<Order> userOrders = userOrderHistory.get(userId);
                if (userOrders == null || userOrders.isEmpty()) {
                    System.out.println("No orders found for User ID: " + userId);
                } else {
                    System.out.println("\nOrder History for User ID " + userId + ":");
                    for (Order o : userOrders) {
                        System.out.println(o);
                    }
                }
            } else if (option == 3) {
                System.out.println("Exiting application.");
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }
}

