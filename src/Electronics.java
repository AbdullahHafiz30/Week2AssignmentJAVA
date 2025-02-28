public class Electronics extends Product {
    private int warrantyInMonths;

    public Electronics(int productId, String name, double price, int stockQuantity, int warrantyInMonths) {
        super(productId, name, "Electronics", price, stockQuantity);
        this.warrantyInMonths = warrantyInMonths;
    }

    public int getWarrantyInMonths() {
        return warrantyInMonths;
    }

    // Override to provide a 10% discount.
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public String toString() {
        return "Electronics [ID=" + getProductId() + ", Name=" + getName() + ", Price=" + getPrice()
                + ", Stock=" + getStockQuantity() + ", Warranty=" + warrantyInMonths + " months]";
    }
}
