import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;

        System.out.println("Enter numbers to sum (enter 0 or a negative number to stop):");

        while (true) {
            double number = sc.nextDouble();

            if (number <= 0) {
                break;
            }

            total += number;
        }

        System.out.println("The total sum is " + total);
    }
}