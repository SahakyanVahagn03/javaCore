package homework.fileUtil;

import java.io.*;
import java.util.Scanner;

public class RecursiveFileUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        fileSearch();
    }


    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("please input directory path");
        String path = scanner.nextLine();
        System.out.println("please input file name ");
        String fileName = scanner.nextLine();
        File file = new File(path);
        if (!(file.exists()) || file.isFile()) {
            System.out.println(false);
        } else {
            System.out.println(recursiveFileSearch(file, fileName) != null);
        }
    }

    private static File recursiveFileSearch(File directory, String fileName) {
        File currentFile = null;
        File[] items = directory.listFiles();
        if (items != null) {
            for (File item : items) {
                if (item.isDirectory()) {
                    currentFile = recursiveFileSearch(item, fileName);
                } else if (item.getName().equals(fileName)) {
                    return item;
                }
            }
        }
        return currentFile;
    }


    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() {
        System.out.println("please input directory path");
        String path = scanner.nextLine();
        System.out.println("please input keyword which would you like for search");
        String keyWord = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            recursiveSearchContent(file, keyWord);
        } else {
            System.out.println("it isn't directory please input correct path");
        }

    }

    private static void recursiveSearchContent(File directory, String keyWord) {
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("directory is empty");
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                recursiveSearchContent(file, keyWord);
            } else {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    String line = "";
                    int inWhichLine = 0;
                    while ((line = bufferedReader.readLine()) != null) {
                        inWhichLine++;
                        if (line.contains(keyWord)) {
                            System.out.println(file.getName() + " in this file contains this keyword-> " + keyWord + " " + inWhichLine + "-th  line");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        String path = scanner.nextLine();
        File file = new File(path);
        System.out.println("in the package total used space is " + findSizeWithRecursive(file) + " byte");
    }

    private static long findSizeWithRecursive(File directory) {
        long fileMb = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    fileMb += findSizeWithRecursive(file);
                } else {
                    fileMb += file.length();
                }
            }
        }
        return fileMb;
    }
}
