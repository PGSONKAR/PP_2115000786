import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilders();
        compareFileReaders();
    }

    public static void compareStringBuilders() {
        int iterations = 1_000_000;
        String text = "hello";

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void compareFileReaders() {
        String filePath = "largefile.txt";
        long startTime, endTime;
        int wordCount = 0;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            startTime = System.nanoTime();
            String line;
            while ((line = fileReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCount);
            System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }

        wordCount = 0;
        try (BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            startTime = System.nanoTime();
            String line;
            while ((line = inputStreamReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCount);
            System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
    }
}
