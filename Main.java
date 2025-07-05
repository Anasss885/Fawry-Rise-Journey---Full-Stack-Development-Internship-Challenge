import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        // All insertions in Product class will handled in backend , no direct interaction with normal user

        // Expirable & Shippable
        Product cheese = new Product(1, "Cheese", 100.0, 10, true, LocalDate.of(2025, 7, 15),250);
        Product biscuits = new Product(2, "Biscuits", 75.0, 15, true, LocalDate.of(2025, 7, 12),25);
        Product milk = new Product(3, "Milk", 60.0, 8, true, LocalDate.of(2025, 7, 5),100);

        // Non-expirable & Shippable
        Product tv = new Product(4, "TV", 3000.0, 5, true, null,2000);

        // Non-expirable & Non-shippable
        Product mobile = new Product(5, "Mobile Scratch Card", 50.0, 25, false, null,350);

        // assuming presence of a specific customer to operate with upcoming operations
        Customer customer1=new Customer(1,"Anas Alaa",6500);
        System.out.println(customer1.getCustomer_balance());
        Cart c1=new Cart(customer1);
        c1.addProduct(cheese,6);
        c1.addProduct(tv,1);
        c1.addProduct(mobile,2);
        c1.calculateSubtotal();
        System.out.println("------------------------------------------------------------");
        c1.getShippableProducts();
        System.out.println("------------------------------------------------------------");
        c1.checkout();




    }



}