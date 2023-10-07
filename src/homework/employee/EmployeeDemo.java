package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();


    private static void methodForAddAnEmployee() {
        System.out.println("this Line you must be write employee's name");
        String name = scanner.nextLine();
        System.out.println("this Line you must be write employee's last name");
        String lastName = scanner.nextLine();
        System.out.println("this Line you must be write employee's salary");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.println("this Line you must be write employee's company");
        String company = scanner.nextLine();
        System.out.println("this Line you must be write employee's position");
        String position = scanner.nextLine();
        employeeStorage.add(new Employee(name, lastName, salary, company, position));
        System.out.println("employee already created");
    }

    private static void printCommands() {
        System.out.println("choose 0 for exit");
        System.out.println("choose 1 for add an employee ");
        System.out.println("choose 2 for print all of the employees");
        System.out.println("choose 3 for search an employee by ID ");
        System.out.println("choose 4 for search an employee by company name  ");
        System.out.println("choose 5 for delete an employee by id");
        System.out.println("choose 6 for Changing employee with id ");
    }

    private static void searchEmployeeByCompanyName() {
        System.out.println("search employee with name of company");
        employeeStorage.searchEmployeeWithNameOfCompany(scanner.nextLine());
    }

    private static void searchEmployeeById() {
        System.out.println("search employee by Id");
        employeeStorage.searchEmployeeById(scanner.nextLine());
    }

    private static void changeAnEmployeeById() {
        System.out.println("write  employee's  id and  change  of  the data");
        employeeStorage.ChangeAnEmployeeById(scanner.nextLine());
    }

    private static void deleteEmployeeById() {
        System.out.println("send employee's  id for delete");
        employeeStorage.deleteEmployById(scanner.nextLine());
    }

    public static void main(String[] args) {
        boolean forRun = true;
        while (forRun) {
            printCommands();
            int forChoose = Integer.parseInt(scanner.nextLine());
            switch (forChoose) {
                case 0:
                    forRun = false;
                    break;
                case 1:
                    methodForAddAnEmployee();
                    break;
                case 2:
                    employeeStorage.print();
                    break;
                case 3:
                    searchEmployeeById();
                    break;
                case 4:
                    searchEmployeeByCompanyName();
                    break;
                case 5:
                    deleteEmployeeById();
                    break;
                case 6:
                    changeAnEmployeeById();
                    break;
            }
        }
    }


}
