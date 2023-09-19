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
            int forWrite = scanner.nextInt();
            switch (forWrite){
                case 1:
                    bool = false;
                    break;
                case 2:
                    System.out.println("write number for adding in the array");
                    int giveNumberForAdd = scanner.nextInt();
                    dynamicArray.add(giveNumberForAdd);
                    System.out.println("number already added");
                    break;
                case 3:
                    System.out.println("give me index and take element by index");
                    int elementByIndex = scanner.nextInt();
                    System.out.println(dynamicArray.getByIndex(elementByIndex));
                    break;
                case 4:
                    dynamicArray.print();
                    break;
                default:
                    System.out.println("selected number is invalid");
            }

        }
    }
}
