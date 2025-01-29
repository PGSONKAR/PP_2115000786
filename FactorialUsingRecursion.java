import java.util.Scanner;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        int number = getInput();
        
        long result = calculateFactorial(number);
        displayResult(result);
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }

    public static long calculateFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }

    public static void displayResult(long result) {
        System.out.println("Factorial: " + result);
    }
}
