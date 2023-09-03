package homework;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("first element of the Array is -> " + numbers[0]);
        System.out.println("last element of the Array is-> " + numbers[numbers.length - 1]);
        System.out.println("the length of the Array is-> " + numbers.length);

        int theSmallestNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (theSmallestNumber > numbers[i]) {
                theSmallestNumber = numbers[i];
            }
        }
        System.out.println("the smallest number of the array is -> " + theSmallestNumber);


        if (numbers.length <= 2) {
            System.out.println("can't print middle values");
        } else {
            if (numbers.length % 2 == 0) {
                System.out.println("middle elements are -> " + numbers[numbers.length / 2 - 1] + " and " + numbers[numbers.length / 2]);
            } else {
                System.out.println("middle element is -> " + numbers[numbers.length / 2]);
            }
        }

        int sizeOfPair = 0;
        int sizeOfOdd = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                sizeOfPair++;
            } else {
                sizeOfOdd++;
            }
        }
        System.out.println("size of pair of the array is -> " + sizeOfPair);
        System.out.println("size of Odd of the array is-> " + sizeOfOdd);

        int sumOfArray = 0;
        for (int number : numbers) {
            sumOfArray += number;
        }
        System.out.println("sum of array is -> " + sumOfArray);
        System.out.println("average of the array is -> " + sumOfArray / numbers.length);
    }
}
