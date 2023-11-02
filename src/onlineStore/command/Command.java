package onlineStore.command;

public interface Command {
    String LOGIN = "0";
    String REGISTER = "1";

    String LOG_OUT = "0";
    String PRINT_ALL_PRODUCTS = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_USERS = "3";
    String Print_ORDERS = "4";
    String CHANGE_ROL_BY_USER_ID = "5";

    String ADD_PRODUCT = "6";

    String CHANGE_ORDER_STATUS = "7";
    String USERS_LOG_OUT = "0";

    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";

    static void printAdminsCommand() {
        System.out.println("input " + LOG_OUT + " for log out");
        System.out.println("input " + PRINT_ALL_PRODUCTS + " Print all products");
        System.out.println("input " + REMOVE_PRODUCT_BY_ID + " Remove product by id");
        System.out.println("input " + PRINT_USERS + "  Print all users");
        System.out.println("input " + Print_ORDERS + " for print orders");
        System.out.println("input " + CHANGE_ROL_BY_USER_ID + " change User's Role");
        System.out.println("input " + ADD_PRODUCT + " for add a product");
        System.out.println("input " + CHANGE_ORDER_STATUS +" for change order status");
    }

    static void printUsersCommand() {
        System.out.println("input " + LOG_OUT + " for log out");
        System.out.println("input " + PRINT_ALL_PRODUCTS + " for Print products");
        System.out.println("input " + BUY_PRODUCT + " for buy product");
        System.out.println("input " + PRINT_MY_ORDERS + " for show my orders");
        System.out.println("input " + CANCEL_ORDER_BY_ID + " for cancel order by id");

    }

    static void primaryCommand() {
        System.out.println("input " + LOGIN + " for login");
        System.out.println("input " + REGISTER + " for register");

    }

}
