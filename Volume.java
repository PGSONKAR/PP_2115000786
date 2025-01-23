class Volume {
    public static void main(String[] args) {
        int radius = 6378;
        double volumekm = ((4 / 3) * 3.14 * (radius * radius * radius));
        double volumemiles = 1.6 * volumekm;
        System.out.println(
                "The volume of earth in cubic kilometers is " + volumekm + " and cubic miles is " + volumemiles);
    }
}