package homework.onlineStore.model;

import homework.onlineStore.model.enums.OrderStatus;
import homework.onlineStore.model.enums.PaymentMethod;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {

    private String id;
    private User user;
    private Product product;
    private int qty;
    private Date date;
    private double price;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;

    public Order(String id, User user, Product product, int qty, Date date, double price, OrderStatus orderStatus, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.qty = qty;
        this.date = date;
        this.price = price;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (qty != order.qty) return false;
        if (Double.compare(price, order.price) != 0) return false;
        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(user, order.user)) return false;
        if (!Objects.equals(product, order.product)) return false;
        if (!Objects.equals(date, order.date)) return false;
        if (orderStatus != order.orderStatus) return false;
        return paymentMethod == order.paymentMethod;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + qty;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", product=" + product +
                ", qty=" + qty +
                ", date=" + date +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
