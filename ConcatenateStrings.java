import java.util.Scanner;
public class ConcatenateStrings {
    public static String concatenateStrings(String[] strings) {
        StringBuffer result = new StringBuffer();

        for (String str : strings) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] strings = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }

        System.out.println("Concatenated string: " + concatenateStrings(strings));
    }
}