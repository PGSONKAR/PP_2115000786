import java.util.Scanner;
public class HandShakeCalculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.println("Maximum number of handshakes: " + maxHandshakes);
    }
}