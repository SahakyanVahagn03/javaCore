package homework.forExample;

public class ForExample {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.print(" -" + (i + 1));
        }
        System.out.println();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(" " + i);
            }
        }
        System.out.println();
        int[] array = {2,5,8,4,9,3,7};
        int biggest = array[0];
        for (int i = 1; i < array.length -1; i++) {
            if (biggest < array[i]){
                biggest = array[i];
            }
        }
        System.out.println(biggest);

    }
}
