package homework.onlineStore.storage;

import homework.onlineStore.model.User;
import homework.onlineStore.model.enums.UserType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserStorage implements Serializable {

    private Map<String, User> users = new HashMap<>();


    public void add(User user) {
        users.put(user.getEmail(), user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void print() {
        for (User user : users.values()) {
            System.out.println(user);
        }

    }

    public User getByEmail(String email) {
        for (Map.Entry<String, User> entry : users.entrySet()) {
            if (entry.getKey().equals(email)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void printByType(UserType userType) {
        for (User user : users.values()) {
            if (user.getUserType() == userType) {
                System.out.println(user);
            }
        }
    }
}
