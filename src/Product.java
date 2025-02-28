public class Product {
    private int ProductID;
    private String Name;
    private String Category;
    private double Price;
    private int StockQuantity;

    public Product(int ProductID, String Name, String Category, double Price, int StockQuantity) {
        this.ProductID = ProductID;
        this.Name = Name;
        this.Category = Category;
        this.Price = Price;
        this.StockQuantity = StockQuantity;
    }

    public int getProductId() {
        return ProductID;
    }

    public String getName() {
        return Name;
    }

    public String getCategory() {
        return Category;
    }

    public double getPrice() {
        return Price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    // Reduces stock and throws an exception if there isn't enough stock.
    public void reduceStock(int quantity) throws OutOfStockException {
        if (StockQuantity < quantity) {
            throw new OutOfStockException("Insufficient stock for product: " + Name);
        }
        StockQuantity -= quantity;
    }

    // Default discount method (can be overridden in sub-classes).
    public double calculateDiscount() {
        return 0;
    }

    public double getDiscountedPrice() {
        return Price - calculateDiscount();
    }

    @Override
    public String toString() {
        return "Product [ID=" + ProductID + ", Name=" + Name + ", Category=" + Category
                + ", Price=" + Price + ", Stock=" + StockQuantity + "]";
    }
}
