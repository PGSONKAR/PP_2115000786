import java.util.Scanner;
public class SumOfNaturalNumbersFor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number >= 0) {
            int formulaSum = number * (number + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= number; i++) {
                loopSum += i;
            }
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);

            if (formulaSum == loopSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is an error in the computations.");
            }
        } else {
            System.out.println("The number " + number + " is not a natural number.");
        }
    }
}
