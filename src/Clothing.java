public class Clothing extends Product {
    private String size;   // e.g., S, M, L
    private String material;

    public Clothing(int productId, String name, double price, int stockQuantity, String size, String material) {
        super(productId, name, "Clothing", price, stockQuantity);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    // Override to provide a discount: 15% off for cotton; otherwise 5%.
    @Override
    public double calculateDiscount() {
        if (material.equalsIgnoreCase("cotton")) {
            return getPrice() * 0.15;
        }
        return getPrice() * 0.05;
    }

    @Override
    public String toString() {
        return "Clothing [ID=" + getProductId() + ", Name=" + getName() + ", Price=" + getPrice()
                + ", Stock=" + getStockQuantity() + ", Size=" + size + ", Material=" + material + "]";
    }
}
