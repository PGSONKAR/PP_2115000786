import java.util.Scanner;

public class FriendComparison {

    public static String findYoungest(int[] ages) {
        int minAge = ages[0];
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestIndex = i;
            }
        }
        return getFriendName(youngestIndex);
    }

    public static String findTallest(double[] heights) {
        double maxHeight = heights[0];
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestIndex = i;
            }
        }
        return getFriendName(tallestIndex);
    }

    public static String getFriendName(int index) {
        switch (index) {
            case 0:
                return "Amar";
            case 1:
                return "Akbar";
            case 2:
                return "Anthony";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];
        System.out.println("Enter the age and height of the friends:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + getFriendName(i) + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + getFriendName(i) + " in meters: ");
            heights[i] = sc.nextDouble();
        }
        String youngest = findYoungest(ages);
        String tallest = findTallest(heights);

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
    }
}
