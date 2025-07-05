public class Customer {
    private int customer_ID;
    private String customer_name;
    private double customer_balance;

    public Customer(int customer_ID, String customer_name, double customer_balance) {
        this.customer_ID = customer_ID;
        this.customer_name = customer_name;
        this.customer_balance = customer_balance;
    }

    public int getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public double getCustomer_balance() {
        return customer_balance;
    }

    public void setCustomer_balance(double customer_balance) {
        this.customer_balance = customer_balance;
    }
    public boolean pay(double amount){ // deducts from the current balance if suffecient (mainly check on avilabiltity to buy according to money)
        double current_balance = getCustomer_balance()-amount;
        if(current_balance>=0){
            setCustomer_balance(current_balance);
            return true;
        }
        else{
            System.out.println("Sorry , your current balance insufficient to buy this product!");
            return false;
        }
    }
}
