import java.util.Arrays;
public class RandomNumberStats {
    public static void main(String[] args) {
        int size = 5; 
        int[] numbers = generate4DigitRandomArray(size);

        System.out.println("Generated numbers: " + Arrays.toString(numbers));

        double[] stats = findAverageMinMax(numbers);
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + stats[1]);
        System.out.println("Maximum: " + stats[2]);
    }

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000; // Generate random number between 1000 and 9999
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = sum / numbers.length;

        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return new double[]{average, min, max};
    }
}