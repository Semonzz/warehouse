import java.util.HashMap;
import java.util.Map;

public class Order {
    private User user;
    private Map<Product, Integer> products  = new HashMap<>();
    private Warehouse warehouse;
    private String count;

    public Order(User user, Map<Product, Integer> products, String count) {
        this.products = products;
        this.user = user;
        this.count = count;
        //doingOrder();
    }

    public void doingOrder() {
        System.out.println("Order created!");
        if (this.count.equals("last")) {
            while (warehouse.getQueueSize() > 0) {
                this.warehouse.processing();
            }
        }
    }

    public void setWarehouse(Warehouse other){
        this.warehouse = other;
    }

    public Map<Product, Integer> getProducts(){
        return this.products;
    }

    public User getUser(){
        return this.user;
    }

    public String getCount(){
        return count;
    }
}
