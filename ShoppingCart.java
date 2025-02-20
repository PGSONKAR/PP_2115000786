import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices;
    private Map<String, Integer> cartOrder;

    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cartOrder = new LinkedHashMap<>();
    }

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, cartOrder.getOrDefault(product, 0) + 1);
    }

    public void displayCartInOrder() {
        System.out.println("Cart Items (In Order of Addition):");
        for (Map.Entry<String, Integer> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue() + " - $" + productPrices.get(entry.getKey()));
        }
    }

    public void displayCartSortedByPrice() {
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedByPrice.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        System.out.println("Cart Items (Sorted by Price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 1.2);
        cart.addProduct("Orange", 2.0);
        cart.addProduct("Banana", 1.2);

        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();
    }
}