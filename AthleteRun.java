import java.util.Scanner;
public class AthleteRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 (meters): ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side 2 (meters): ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3 (meters): ");
        double side3 = sc.nextDouble();

        double perimeter = side1 + side2 + side3;
        int rounds = (int) Math.ceil(5000 / perimeter);
        
        System.out.println("Number of rounds to complete 5 km: " + rounds);
    }
}