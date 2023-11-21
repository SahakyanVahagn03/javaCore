package homework.onlineStore.storage;

import homework.onlineStore.model.Order;
import homework.onlineStore.model.User;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OrderStorage implements Serializable {

    private List<Order> orders = new  LinkedList<>();


    public void add(Order order) {
       orders.add(order);
       StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void print() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }


    public Order getById(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }

    public void printByUser(User currentUser) {
        for (Order order : orders) {
            if (order.getUser().equals(currentUser)){
                System.out.println(order);
            }
        }

    }
}
