import java.util.Scanner;
public class DivisibilityCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        String result = (number % 5 == 0) ? "Yes" : "No";

        System.out.println("Is the number " + number + " divisible by 5? " + result);
    }
}