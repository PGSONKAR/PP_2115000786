import java.util.*;

class InputDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  your fee: ");
        int fee = sc.nextInt();
        System.out.println("Enter your discount percentage: ");
        int discountPercent = sc.nextInt();
        int discountdone = fee / discountPercent;
        int discountedfee = fee - discountdone;
        System.out.println(
                "The discount amount is INR  " + discountdone + " and final discounted fee is INR " + discountedfee);
    }
}