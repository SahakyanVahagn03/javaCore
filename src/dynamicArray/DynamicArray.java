package dynamicArray;

import java.util.Scanner;

public class DynamicArray {
    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value) {
        checkIfNeedToExtend();
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
            System.out.print("you sent invalid index. the index of array must be a correct,index doesn't be big from size and It doesn't small from 0. | error ");
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

    public void deleteByIndex(int index) {
        checkIfNeedToExtend();
        if (index < 0 || size < index) {
            System.out.println("similar element doesn't exist");
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }

    }

    public void set(int index, int value) {
        if (index > size || index < 0) {
            System.out.println("the index doesn't exist");
        } else {
            array[index] = value;
        }
    }

    public void add(int index, int value) {
        checkIfNeedToExtend();
        if (index > size || index < 0) {
            System.out.println("the index doesn't exist");
        } else {
            for (int i = size; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = value;
            size++;
        }
    }

    public boolean exists(int value) {
        for (int valueOfTheArray : array) {
            if (valueOfTheArray == value) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void checkIfNeedToExtend() {
        if (size == array.length) {
            extend();
        }
    }
}
