import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;
        double number;

        System.out.println("Enter numbers to sum (enter 0 to stop):");

        while ((number = sc.nextDouble()) != 0) {
            total += number;
        }

        System.out.println("The total sum is " + total);
    }
}