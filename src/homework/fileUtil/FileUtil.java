package homework.fileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


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
        File file = new File(path + File.separator + fileName);
        System.out.println(file.exists());
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
        File[] file = new File(path).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        if (file == null) {
            System.out.println("files with that path" + path + " doesn't exist");
            return;

        }
        for (File item : file) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(item))) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains(keyWord)) {
                        System.out.println(item.getName());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        String textPath = scanner.nextLine();
        String keyWord = scanner.nextLine();
        File file = new File(textPath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = "";
            int inWhichLine = 0;
            while ((line = bufferedReader.readLine()) != null) {
                inWhichLine++;
                if (line.contains(keyWord)) {
                    System.out.println("in this file-> " + file.getName() + " in " + inWhichLine + "-th  line");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        String path = scanner.nextLine();
        File[] files = new File(path).listFiles();
        long fileMb = 0;
        if (files == null) {
            System.out.println("files with that path "+path+ " doesn't exist");
            return;
        }
        for (File file : files) {
            System.out.println(file.getName() + " this file used space is " + file.length() + " byte");
            fileMb += file.length();
        }
        System.out.println("in the package total used space is " + fileMb + " byte");
    }


    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("please input directory path");
        String path = scanner.nextLine();
        System.out.println("please input file name ");
        String fileName = scanner.nextLine();
        System.out.println("please input content");
        String content = scanner.nextLine();
        File file = new File(path + File.separator + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}