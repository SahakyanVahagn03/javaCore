package dynamicArray;

import dynamicArray.DynamicArray;

import java.util.Scanner;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        while (bool) {
            System.out.println("if you choose 1 you go to outside from program");
            System.out.println("if you choose 2 you can be add to element in the array");
            System.out.println("if you choose 3 you can be take element by index");
            System.out.println("if you choose 4 you can be print all the elements of the array ");
            System.out.println("if you choose 5 you can delete the index ");
            System.out.println("if you choose 6 you can change the old value by new");
            System.out.println("if you choose 7 you can add a element without the need delete any element of the array");
            System.out.println("if you choose 8 you can write a value and take true if value is exist");
            System.out.println("if you choose 9 you can set the value and get the index");

            int forWrite = scanner.nextInt();
            switch (forWrite) {
                case 1:
                    bool = false;
                    break;
                case 2:
                    System.out.println("write number for adding in the array");
                    dynamicArray.add(scanner.nextInt());
                    System.out.println("number already added");
                    break;
                case 3:
                    System.out.println("give me index and take element by index");
                    System.out.println(dynamicArray.getByIndex(scanner.nextInt()));
                    break;
                case 4:
                    dynamicArray.print();
                    break;
                case 5:
                    System.out.println("write index for delete");
                    dynamicArray.deleteByIndex(scanner.nextInt());
                    break;
                case 6:
                    System.out.println("write the index and value");
                    dynamicArray.set(scanner.nextInt(), scanner.nextInt());
                    break;
                case 7:
                    System.out.println("write the index and value");
                    dynamicArray.add(scanner.nextInt(), scanner.nextInt());
                    break;
                case 8:
                    System.out.println("write the value");
                    System.out.println(dynamicArray.exists(scanner.nextInt()));
                    break;

                case 9:
                    System.out.println("write the value");
                    System.out.println(dynamicArray.getIndexByValue(scanner.nextInt()));
                    break;

                default:
                    System.out.println("selected number is invalid");
            }

        }
    }
}
