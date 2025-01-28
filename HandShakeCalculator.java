import java.util.Scanner;
public class HandShakeCalculator {
    public static int maxHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        System.out.println("Maximum number of handshakes: " + maxHandshakes(n));
    }
}