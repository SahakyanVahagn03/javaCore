package homework;

import java.util.Scanner;

public class DynamicArray {
    // I wrote main in this class, scroll down and will find it :)

    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    //1․ ստեղծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ
    //2․ քցել հին մասիվի էլեմենտները նորի մեջ
    //3․ հին մասիվի հղումը կապենք նոր մասիվի հղման հետ։
    private void extend() {
        int[] tamp = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            tamp[i] = array[i];
        }
        array = tamp;
    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
    public int getByIndex(int index) {
        if (index < 0 || size < index) {
            System.out.print("you sent invalid index. the index of array must be a correct,index doesn't be big from size and It doesn't small from 0. | ");
            return -1;
        }
        return array[index];
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    // the main starts at this line :)
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
                    dynamicArray.getByIndex(elementByIndex);
                    break;
                case 4:
                    dynamicArray.print();
                    break;
                default:
                    System.out.println("invalid index");
            }

        }
    }
}
