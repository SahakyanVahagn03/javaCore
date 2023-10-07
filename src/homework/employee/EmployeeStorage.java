package homework.employee;

import java.util.Scanner;

public class EmployeeStorage {
    private Employee[] array = new Employee[10];
    private int size;
    private Scanner scanner = new Scanner(System.in);

    private void checkIfNeedToExtend() {
        if (size == array.length) {
            extend();
        }
    }

    private void extend() {
        Employee[] tamp = new Employee[array.length + 10];
        if (size >= 0) System.arraycopy(array, 0, tamp, 0, size);
        array = tamp;
    }

    public void add(Employee value) {
        checkIfNeedToExtend();
        array[size++] = value;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);

        }
        System.out.println();
    }

    public void searchEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEmployeeId().equals(employeeId)) {
                System.out.println(array[i]);
            }
        }
    }

    public void searchEmployeeWithNameOfCompany(String nameOfCompany) {
        for (int i = 0; i < size; i++) {
            if (array[i].getCompany().contains(nameOfCompany)) {
                System.out.println(array[i]);
            }
        }
    }

    public void deleteEmployById(String id) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEmployeeId().equals(id)) {
                for (int j = i; j < size; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                break;
            }
        }
        print();
    }

    public void ChangeAnEmployeeById(String id) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEmployeeId().equals(id)) {
                System.out.println("please write your data for change");
                System.out.println("name");
                array[i].setName(scanner.nextLine());
                System.out.println("surname");
                array[i].setSurName(scanner.nextLine());
                System.out.println("company name");
                array[i].setCompany(scanner.nextLine());
                System.out.println("position");
                array[i].setPosition(scanner.nextLine());
                System.out.println("salary");
                array[i].setSalary(Integer.parseInt(scanner.nextLine()));
                break;
            }
        }
    }
}

