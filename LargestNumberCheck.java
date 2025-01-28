import java.util.Scanner;
public class LargestNumberCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        String firstLargest = (number1 > number2 && number1 > number3) ? "Yes" : "No";
        String secondLargest = (number2 > number1 && number2 > number3) ? "Yes" : "No";
        String thirdLargest = (number3 > number1 && number3 > number2) ? "Yes" : "No";

        System.out.println("Is the first number the largest? " + firstLargest);
        System.out.println("Is the second number the largest? " + secondLargest);
        System.out.println("Is the third number the largest? " + thirdLargest);
    }
}