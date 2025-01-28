import java.util.*;
public class MultiplicationT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int[] multiplicationResult = new int[4]; 
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i; 
        }
        System.out.println("Multiplication Table of " + number + " from 6 to 9:");
        for (int i = 0; i < 4; i++) {
            System.out.println(number + " x " + (i + 6) + " = " + multiplicationResult[i]);
        }
   }
}
