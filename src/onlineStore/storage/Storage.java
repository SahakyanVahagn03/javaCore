package onlineStore.storage;


import onlineStore.exception.OutOfStockException;
import onlineStore.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Storage {
    Object[] array = new Object[10];
    private int size;

    public Storage() {
        size = -1;
    }

    public void add(Object value) {
        if (array.length == size) {
            extend();
        }
        array[++size] = value;
    }

    private void extend() {
        Object [] tamp = new Object[array.length + 10];
        if (size >= 0) System.arraycopy(array, 0, tamp, 0, size);
        array = tamp;
    }

    public void print() {
        for (int i = 0; i <= size; i++) {
            System.out.println(array[i]);
        }
    }

    public void removeProductById(String id) {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof Product product) {
                if (Pattern.matches(product.getId(), id)) {
                    for (int j = i; j <= size; j++) {
                        array[j] = array[j + 1];
                    }
                    array[size] = null;
                    size--;
                    break;
                }
            }
        }
    }


    public Object findUserBYEmail(String email) {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof User user) {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            }
        }
        return null;
    }

    public void printUsers() {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof User user && user.getRole() == Role.USER) {
                System.out.println(user);
            }
        }
    }

    public void printCurrentOrders(Object currentUser) {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof Order order && order.getUser().equals(currentUser)) {
                System.out.println(array[i]);
            }
        }
    }

    public Object getProductById(String id) {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof Product product && product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public double costOfTheProduct(Product currentProduct, double count) throws OutOfStockException {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof Product product) {
                if (product.equals(currentProduct)) {
                    if (product.getStockQty() < count || product.getStockQty() == 0) {
                        throw new OutOfStockException("stock is empty");
                    }
                    return product.getPrice() * count;
                }
            }
        }
        throw new OutOfStockException("Stock doesn't exist");
    }

    public void cancelOrderById(String id) {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof Order order && Pattern.matches(order.getId(), id)) {
                order.setOrderStatus(OrderStatus.CANCELED);
                return;
            }
        }
    }


    public void methDelivered(User user) {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof Order order) {
                if (order.getUser().equals(user) && order.getOrderStatus() == OrderStatus.NEW) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(order.getDate());
                    calendar.add(Calendar.DAY_OF_MONTH, 29);
                    Date dateOfDelivered = calendar.getTime();
                    if (new Date().after(dateOfDelivered)) {
                        order.setOrderStatus(OrderStatus.DELIVERED);
                        order.getProduct().setStockQty(order.getProduct().getStockQty() - order.getQty());
                    }
                }
            }
        }
    }

    public Object getUserById(String id) {
        for (int i = 0; i <= size; i++) {
            if (array[i] instanceof User user && Pattern.matches(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    public void changeUserRolById(User userById) {
        userById.setRole(Role.ADMIN);
    }
}
