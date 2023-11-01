package onlineStore;

import onlineStore.command.Command;
import onlineStore.exception.OutOfStockException;
import onlineStore.model.*;
import onlineStore.storage.Storage;
import onlineStore.util.CheckingUtil;

import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);


    private static User currentUser;
    private static final Storage userStorage = new Storage();
    private static final Storage orderStorage = new Storage();
    private static final Storage praductStorage = new Storage();


    public static void main(String[] args) {
        userStorage.add(new User("Vahag", "vahag@mail.ru", "12345", Role.ADMIN));
        boolean run = true;
        while (run) {
            Command.primaryCommand();
            String command = SCANNER.nextLine();
            switch (command) {
                case Command.LOGIN:
                    login();
                    break;
                case Command.REGISTER:
                    register();
                    break;
            }
        }
    }

    private static void login() {
        System.out.println("input your email");
        String email = SCANNER.nextLine();
        System.out.println("password");
        String password = SCANNER.nextLine();
        User user = (User) userStorage.findUserBYEmail(email);
        if (CheckingUtil.checkPassword(user, password)) {
            currentUser = user;
            if (user.getRole() == Role.ADMIN) {
                adminPanel();
            } else if (user.getRole() == Role.USER) {
                userPanel();
            }
        } else {
            System.out.println("data isn't correct, please login again");
            return;
        }
        System.out.println("everything is correct, you can enter your profile");
    }


    private static void register() {
        System.out.println("please input your name");
        String name = SCANNER.nextLine();
        System.out.println("please input your email");
        String email = SCANNER.nextLine();
        Object userBYEmail = userStorage.findUserBYEmail(email);
        System.out.println("please input your password");
        String password = SCANNER.nextLine();
        if (userBYEmail != null || !CheckingUtil.checkEmail(email) || password.isEmpty()) {
            System.out.println("this data is incorrect, try again ");
            return;
        }
        userStorage.add(new User(name, email, password, Role.USER));
        login();
    }

    private static void adminPanel() {
        boolean run = true;

        while (run) {
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("'your profile' -> " + currentUser.getName() + " | your Role{" + currentUser.getRole() + "}" + " | user id " + currentUser.getId());
            Command.printAdminsCommand();
            String command = SCANNER.nextLine();
            switch (command) {
                case Command.LOG_OUT:
                    run = false;
                    break;
                case Command.PRINT_ALL_PRODUCTS:
                    praductStorage.print();
                    break;
                case Command.ADD_PRODUCT:
                    addProduct();
                    break;
                case Command.PRINT_USERS:
                    userStorage.printUsers();
                    break;
                case Command.REMOVE_PRODUCT_BY_ID:
                    System.out.println("input product id for delete a product");
                    praductStorage.removeProductById(SCANNER.nextLine());
                    break;
                case Command.Print_ORDERS:
                    orderStorage.print();
                    break;
                case Command.CHANGE_ROL_BY_USER_ID:
                    changeUserRole();
                    break;
            }
        }

    }

    private static void changeUserRole() {
        System.out.println("input User id for change");
        String id = SCANNER.nextLine();
        User userById = (User) userStorage.getUserById(id);
        if (userById == null) {
            System.out.println("that user with " + id + " " + " doesn't exist");
            return;
        }
        userStorage.changeUserRolById(userById);
        System.out.println("that user Role already ADMIN");
    }

    private static void addProduct() {
        System.out.println("add name of the product");
        String name = SCANNER.nextLine();
        System.out.println("add description of the product");
        String description = SCANNER.nextLine();
        System.out.println("add price of the product");
        String priceWithStr = SCANNER.nextLine();
        System.out.println("add count of the product in stock");
        String stockQtyWithStr = SCANNER.nextLine();
        Category[] category = Category.values();
        for (Category value : category) {
            System.out.print(value.ordinal() + ") " + value + " ");
        }
        System.out.println();
        System.out.println("add product category");
        String selectedCategory = SCANNER.nextLine();
        if (!CheckingUtil.isDigit(priceWithStr) || !CheckingUtil.isDigit(stockQtyWithStr) || !CheckingUtil.isDigit(selectedCategory)) {
            System.err.println("that fields (stock, price and category) "  + " must be only digit");
            return;
        }
        double price = Double.parseDouble(priceWithStr);
        int stockQty = Integer.parseInt(stockQtyWithStr);
        if (Integer.parseInt(selectedCategory) >= category.length && Integer.parseInt(selectedCategory) < 0) {
            System.err.println("please select correct category, that category doesn't exist");
        } else {
            praductStorage.add(new Product(name, description, price, stockQty, category[Integer.parseInt(selectedCategory)]));
        }
    }

    private static void userPanel() {
        boolean run = true;
        while (run) {
            orderStorage.methDelivered(currentUser);
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println("'your profile' -> " + currentUser.getName() + " | your Role{" + currentUser.getRole() + "}" + " | user id " + currentUser.getId());
            Command.printUsersCommand();
            String command = SCANNER.nextLine();
            switch (command) {
                case Command.LOG_OUT:
                    run = false;
                    break;
                case Command.PRINT_ALL_PRODUCTS:
                    praductStorage.print();
                    break;
                case Command.BUY_PRODUCT:
                    CheckForBuy();
                    break;
                case Command.PRINT_MY_ORDERS:
                    orderStorage.printCurrentOrders(currentUser);
                    break;
                case Command.CANCEL_ORDER_BY_ID:
                    System.out.println("input id for cancel");
                    orderStorage.cancelOrderById(SCANNER.nextLine());
                    break;

            }
        }


    }


    private static void CheckForBuy() {
        praductStorage.print();
        System.out.println("please write id of the product");
        String productId = SCANNER.nextLine();
        Product product = (Product) praductStorage.getProductById(productId);
        if (product == null) {
            System.err.println("product " + productId + " " + " doesn't exist");
            return;
        }
        System.out.println("how many products would you like");
        String countWithStr = SCANNER.nextLine();
        if (!CheckingUtil.isDigit(countWithStr)) {
            System.err.println("price can't be String -> " + countWithStr);
            return;
        }
        double totalPayment = 0.0;
        try {
            totalPayment = praductStorage.costOfTheProduct(product, Double.parseDouble(countWithStr));
        } catch (OutOfStockException e) {
            throw new RuntimeException(e.getMessage());
        }
        buyProduct(product, totalPayment, Integer.parseInt(countWithStr));
    }

    private static void buyProduct(Product product, double totalPayment, int count) {
        PaymentMethod[] paymentMethods = PaymentMethod.values();
        for (PaymentMethod value : paymentMethods) {
            System.out.print(value.ordinal() + ") " + value + " ");
        }
        System.out.println("select your payment methods");
        String payMeth = SCANNER.nextLine();
        if (!CheckingUtil.isDigit(payMeth) || paymentMethods.length <= Integer.parseInt(payMeth)) {
            System.err.println("this payment method doesn't exist");
            userPanel();
        }
        System.out.println("will you want to buy this product this count " + count + " total cost is " + totalPayment +
                " if you want to buy. write - [yes} if you won't to buy, write- {any word}");
        String question = SCANNER.nextLine();
        if (question.equals("yes")) {
            orderStorage.add(new Order(currentUser, product, new Date(), totalPayment, OrderStatus.NEW, count, paymentMethods[Integer.parseInt(payMeth)]));
            System.out.println("order already registered");
        } else {
            userPanel();
        }
    }
}
