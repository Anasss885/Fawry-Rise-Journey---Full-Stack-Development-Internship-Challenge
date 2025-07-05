import java.time.LocalDate;

public class Product {
    private int product_ID;
    private String product_name;
    private double product_price;
    private int product_quantity;
    private boolean shippable;
    private LocalDate expiryDate;
    private double wieight;
    public Product(int product_ID, String product_name, double product_price, int product_quantity, boolean shippable, LocalDate expired,double wieight) {
        this.product_ID = product_ID;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
        this.shippable = shippable;
        this.expiryDate = expiryDate;
        this.wieight=wieight;

    }

//    public LocalDate getExpiryDate() {
//        return expiryDate;
//    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getWieight() {
        return wieight;
    }

    public void setWieight(double wieight) {
        this.wieight = wieight;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public boolean isShippable() {
        return shippable;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    public boolean isExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }

    public void setExpired(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    // Optional: toString method to print object details
    @Override
    public String toString() {
        return "Product{" +
                "product_ID=" + product_ID +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_quantity=" + product_quantity +
                ", shippable=" + shippable +
                ", wieight=" + wieight +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
