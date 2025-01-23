class Discount {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        int discountdone = fee / discountPercent;
        int discountedfee = fee - discountdone;
        System.out.println(
                "The discount amount is INR  " + discountdone + " and final discounted fee is INR " + discountedfee);
    }
}