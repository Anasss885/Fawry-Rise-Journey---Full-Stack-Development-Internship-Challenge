import java.util.*;

public class Cart {
    private Customer customer; // dependency injection property , we need to fixing one customer per each cart
    private Map<Product, Integer> cartItems = new HashMap<>();

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > product.getProduct_quantity()) {
            System.out.println("Sorry, there's not enough stock for: " + product.getProduct_name());
            return;
        }

        if (product.isExpired()) {
            System.out.println("Cannot add expired product: " + product.getProduct_name());
            return;
        }

        double totalPrice = product.getProduct_price() * quantity;

        if (customer.pay(totalPrice)) {
            cartItems.put(product, quantity);  // Replace quantity if already exists
            System.out.println(quantity + "x " + product.getProduct_name() + " added to cart.");
        } else {
            System.out.println("Insufficient balance to add " + product.getProduct_name());
        }
    }

    public boolean isEmpty() {
        return cartItems.isEmpty(); // checking if our map is empty , so there's no cart
    }

    public double calculateSubtotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().getProduct_price() * entry.getValue(); // unit price * quantity to get our total
        }
        return total;
    }

    public void getShippableProducts() {
        List<Product> shippables = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            if (entry.getKey().isShippable()) {
                shippables.add(entry.getKey());
            }
        }
        System.out.println("Our Shippable Products are :");
        for(Product p:shippables){
            System.out.println(p.getProduct_name());
        }

    }

    public void checkout() {
        if (isEmpty()) {
            System.out.println("Cart is empty. Cannot proceed to checkout.");
            return;
        }

        System.out.println("\n--- CHECKOUT RECEIPT ---");

        double subtotal = 0.0;
        double shippingFee = 0.0;

        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.isExpired()) {
                System.out.println("Cannot checkout expired product: " + product.getProduct_name());
                return;
            }

            if (quantity > product.getProduct_quantity()) {
                System.out.println("Product out of stock during checkout: " + product.getProduct_name());
                return;
            }

            double linePrice = product.getProduct_price() * quantity;
            subtotal += linePrice;

            System.out.println(quantity + "x " + product.getProduct_name() + " = " + linePrice);
        }

        // For simplicity, fixed shipping fee
        shippingFee = 30.0;

        double totalAmount = subtotal + shippingFee;

        // Final balance check before committing transaction

        if (customer.getCustomer_balance() < shippingFee) {
            System.out.println("Insufficient balance to cover shipping.");
            return;
        }
        customer.pay(shippingFee);


        System.out.println("------------------------------");
        System.out.println("Subtotal:      " + subtotal);
        System.out.println("Shipping:      " + shippingFee);
        System.out.println("Total:         " + totalAmount);
        System.out.println("Remaining Balance: " + customer.getCustomer_balance());

        // Update product stock
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setProduct_quantity(product.getProduct_quantity() - quantity);
        }

        // Clear cart after checkout
        cartItems.clear();
    }
}
