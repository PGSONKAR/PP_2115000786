import java.util.*;

class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = sc.nextDouble();
        double feetPerYard = 3.0;
        double yardsPerMile = 1760.0;
        double distanceInYards = distanceInFeet / feetPerYard;
        double distanceInMiles = distanceInYards / yardsPerMile;
        System.out.println("The distance in yards is " + distanceInYards + " and in miles is " + distanceInMiles);
    }
}