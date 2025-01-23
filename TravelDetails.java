import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter the starting city (fromCity): ");
        String fromCity = sc.nextLine();

        System.out.print("Enter the via city (viaCity): ");
        String viaCity = sc.nextLine();

        System.out.print("Enter the destination city (toCity): ");
        String toCity = sc.nextLine();

        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = sc.nextDouble();

        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = sc.nextDouble();

        System.out.print("Enter the time taken for the journey in hours: ");
        double timeTaken = sc.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;

        System.out.println("Travel Summary:");
        System.out.println("Traveler: " + name);
        System.out.println("Journey: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Average Speed: " + averageSpeed + " miles per hour");

        System.out.print("Enter the fee: ");
        int fee = sc.nextInt();

        System.out.print("Enter the discount percent: ");
        int discountPercent = sc.nextInt();

        int discountedPrice = fee - (fee * discountPercent / 100);
        int remainingAmount = fee - discountedPrice;

        System.out.println(
                "The results of integer operations are " + discountedPrice + ", " + remainingAmount + ", and " + fee);
    }
}
