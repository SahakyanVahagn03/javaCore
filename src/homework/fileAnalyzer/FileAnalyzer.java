package homework.fileAnalyzer;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) {
        // Читаем файл, составляем мапу слово-количество и возвращаем ее
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (!map.containsKey(line)) {
                    map.put(line, 1);
                } else {
                    Integer i = map.get(line);
                    map.replace(line, ++i);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return map;
    }

    public int totalWordCount(String path) {
        // Читаем файл, подсчитываем общее количество слов
        int wordCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                ++wordCount;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordCount;
    }

    public int uniqueWordCount(String path) {
        // Читаем файл, подсчитываем количество уникальных слов
        Map<String, Integer> words = wordMap(path);
        int count = 0;
        for (Integer value : words.values()) {
            if (value <= 1) {
                ++count;
            }
        }

        return count;
    }


    public Map<String, Integer> topFrequentWords(String path, int n) {
        // Читаем файл, находим топ-N часто встречающихся слов
        return sortedList(wordMap(path), n);
    }

    private Map<String, Integer> sortedList(Map<String, Integer> words, int n) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (list.size() < n) {
            hashMap.put("txt file is empty", 0);
        } else {
            for (int i = 0; i < n; i++) {
                hashMap.put(list.get(i).getKey(), list.get(i).getValue());
            }
        }
        return hashMap;
    }

    public int countWordOccurrences(String path, String word) {
        // Читаем файл, находим количество вхождений слова и возвращаем это число
        int wordCount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(word)) {
                    ++wordCount;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordCount;
    }

}
