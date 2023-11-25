package homework.fileAnalyzer;


import java.util.Map;
import java.util.Scanner;

public class FileAnalyzerMain {
    //
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final FileAnalyzer FILE_ANALYZER = new FileAnalyzer();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("select 1 -> which will return map. key(the word in the file) and value(the count of that word)");
            System.out.println("select 2 - > if you want to Count the total number of words in the file");
            System.out.println("select 3 - > if you want to count unique Words number ");
            System.out.println("select 4 - > if you want to find top-n  frequently occurring Words in the file");
            System.out.println("select 5 - > if you want to search the word and count Word Occurrences");
            switch (SCANNER.nextLine()) {
                case "0":
                    run = false;
                    break;
                case "1":
                    wordMap();
                    break;
                case "2":
                    System.out.println("please write path of the file");
                    System.out.println("total count of the words in the file is ->  "+ FILE_ANALYZER.totalWordCount(SCANNER.nextLine()));
                    break;
                case "3":
                    System.out.println("please write path of the file");
                    System.out.println("count of the unique words in the file is -> " + FILE_ANALYZER.uniqueWordCount(SCANNER.nextLine()));
                    break;
                case "4":
                    topFrequentWords();
                    break;
                case "5":
                    countWordOccurrences();
                    break;

            }
        }
    }

    private static void wordMap() {
        System.out.println("please input path of the file");
        Map<String, Integer> map = FILE_ANALYZER.wordMap(SCANNER.nextLine());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static void topFrequentWords() {
        System.out.println("please write path of the file");
        String path = SCANNER.nextLine();
        System.out.println("write   top-N, which top-N  frequently occurring words you want to see");
        String topN = SCANNER.nextLine();
        if (!topN.chars().allMatch(Character::isDigit)){
            System.err.println("in the top-N you must write only number ");
            return;
        }
        Map<String, Integer> map = FILE_ANALYZER.topFrequentWords(path, Integer.parseInt(topN));
        System.out.println("top "+ topN + "  frequently occurring words in the file");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void countWordOccurrences() {
        System.out.println("please write path of the file");
        String path = SCANNER.nextLine();
        System.out.println("please write the word");
        String word = SCANNER.nextLine();
        System.out.println("this word Occurrences "+ FILE_ANALYZER.countWordOccurrences(path, word) + " times");
    }
}
