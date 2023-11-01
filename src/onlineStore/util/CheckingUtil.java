package onlineStore.util;

import onlineStore.model.User;

import java.util.regex.Pattern;

public class CheckingUtil {
    public static boolean checkPassword(User user, String password) {
        if (user == null) {
            return false;
        }
        return Pattern.matches(user.getPassword(), password);
    }

    public static boolean checkEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", email);
    }

    public static boolean isDigit(String val) {
        return val.chars().allMatch(Character::isDigit);
    }

}
