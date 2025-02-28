public class OrderDetails {
    private int orderDetailId;
    private int orderId;
    private Product product;
    private int quantity;
    private double subTotal;

    public OrderDetails(int orderDetailId, int orderId, Product product, int quantity) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        // Calculate subtotal based on the product's discounted price.
        this.subTotal = product.getDiscountedPrice() * quantity;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    @Override
    public String toString() {
        return "OrderDetails [ID=" + orderDetailId + ", Product=" + product.getName()
                + ", Quantity=" + quantity + ", SubTotal=" + subTotal + "]";
    }
}
