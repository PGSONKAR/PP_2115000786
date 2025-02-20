import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        String text = "Hello world, hello Java!";
        Map<String, Integer> wordCount = countWordFrequency(text);
        System.out.println(wordCount);
    }

    private static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}