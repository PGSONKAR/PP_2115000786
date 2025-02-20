import java.util.*;
public class StringFrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : list) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        return frequencyMap;
    }
        public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = countFrequency(input);
        System.out.println(result);
    }
}