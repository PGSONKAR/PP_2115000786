import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number1 = sc.nextDouble();
        double number2 = sc.nextDouble();
        number1 = number1 + number2;
        number2 = number1 - number2;
        number1 = number1 - number2;
        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}
