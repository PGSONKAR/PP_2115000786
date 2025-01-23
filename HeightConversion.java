import java.util.Scanner;

class HeightConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your height in cm: ");
        double heightCm = sc.nextDouble();

        double cmPerInch = 2.54;
        int inchesPerFoot = 12;

        double totalInches = heightCm / cmPerInch;
        int feet = (int) (totalInches / inchesPerFoot);
        double inches = Math.round(totalInches % inchesPerFoot * 100.0) / 100.0;

        System.out
                .println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches);
    }
}