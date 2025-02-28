import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private List<OrderDetails> orderDetailsList;

    public Order(int orderId, int userId) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDetailsList = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void addOrderDetails(OrderDetails orderDetails) {
        orderDetailsList.add(orderDetails);
    }

    public double getTotal() {
        double total = 0;
        for (OrderDetails od : orderDetailsList) {
            total += od.getSubTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order [ID=" + orderId + ", UserID=" + userId + ", Details=" + orderDetailsList
                + ", Total=" + getTotal() + "]";
    }
}
