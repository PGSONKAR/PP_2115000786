import java.util.*;

class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base of the triangle in inches: ");
        double base = sc.nextDouble();
        System.out.print("Enter the height of the triangle in inches: ");
        double height = sc.nextDouble();
        double areaInSquareInches = 0.5 * base * height;
        double areaInSquareCm = areaInSquareInches * 2.54 * 2.54;
        System.out.println("The area of the triangle in square inches is " + areaInSquareInches
                + " and in square centimeters is " + areaInSquareCm);
    }
}