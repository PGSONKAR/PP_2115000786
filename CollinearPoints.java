import java.util.Scanner;

public class CollinearPoints {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = 2;
        int y1 = 4;
        int x2 = 4;
        int y2 = 6;
        int x3 = 6;
        int y3 = 8;
        boolean collinearSlope = areCollinearSlope(x1, y1, x2, y2, x3, y3);
        boolean collinearArea = areCollinearArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Using Slope Formula: Collinear? " + collinearSlope);
        System.out.println("Using Area of Triangle Formula: Collinear? " + collinearArea);
    }

    public static boolean areCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);
        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    public static boolean areCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }
}