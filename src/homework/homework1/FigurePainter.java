package homework.homework1;

public class FigurePainter {

    public static void main(String[] args) {
        int length = 7;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < length; i++) {
            for (int j = length; j > i; j--) {
                System.out.print(" * ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < length; i++) {
            for (int j = length; j > i + 1; j--) {
                System.out.print("   ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            for (int j = length; j > i; j--) {
                System.out.print("  *");
            }
            System.out.println();
            for (int j = 0; j < i + 1; j++) {
                System.out.print("   ");
            }

        }

        System.out.println();

        for (int i = 0; i < length - 1; i++) {
            for (int j = length; j > i + 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < length; i++) {
            for (int j = length; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }

        }

        

    }
}
