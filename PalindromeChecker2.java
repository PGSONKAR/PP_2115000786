import java.util.Scanner;
public class PalindromeChecker2 {
    public static void main(String[] args) {
        String input = getInput();
        
        if (isPalindrome(input)) {
            displayResult(input + " is a palindrome.");
        } else {
            displayResult(input + " is not a palindrome.");
        }
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    public static boolean isPalindrome(String input) {
        input = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public static void displayResult(String result) {
        System.out.println(result);
    }
}