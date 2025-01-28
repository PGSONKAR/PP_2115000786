import java.util.*;
public class NumberChecker2 {
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigitsArray(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        int[] digitsArray = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            digitsArray[i] = digits.get(digits.size() - 1 - i);
        }
        return digitsArray;
    }

    public static int findSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int findSumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sumOfDigits = findSumOfDigits(digits);
        return number % sumOfDigits == 0;
    }

    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }

    public static void main(String[] args) {
        int number = 156;

        int count = countDigits(number);
        int[] digits = getDigitsArray(number);
        int sumOfDigits = findSumOfDigits(digits);
        int sumOfSquares = findSumOfSquaresOfDigits(digits);
        boolean isHarshad = isHarshadNumber(number, digits);
        int[][] frequency = findDigitFrequency(digits);

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + count);
        System.out.print("Digits array: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println("\nSum of digits: " + sumOfDigits);
        System.out.println("Sum of squares of digits: " + sumOfSquares);
        System.out.println("Is Harshad Number: " + isHarshad);
        System.out.println("Digit frequencies:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println("Digit: " + frequency[i][0] + ", Frequency: " + frequency[i][1]);
            }
        }
    }
}