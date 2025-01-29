public class MostFrequentCharacter {
    public static void main(String[] args) {
        String input = "success";
        int[] frequency = new int[256];
        char mostFrequentChar = input.charAt(0);
        int maxCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            frequency[ch]++;
            if (frequency[ch] > maxCount) {
                maxCount = frequency[ch];
                mostFrequentChar = ch;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }
}