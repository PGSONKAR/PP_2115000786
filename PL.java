class PL {
    public static void main(String[] args) {
        double cost = 129;
        double sell = 191;
        double profit = sell - cost;
        double profitp = (profit / cost) * 100;
        System.out.println("The Cost Price is INR " + cost + " and Selling Price is INR " + sell);
        System.out.println("The Profit is INR  " + profit + " and the Profit Percentage is " + profitp + "%");
    }
}