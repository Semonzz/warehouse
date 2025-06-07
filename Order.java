import java.util.HashMap;
import java.util.Map;

public class Order {
    private User user;
    private Map<Product, Integer> products  = new HashMap<>();
    private Warehouse warehouse;
    private String count;

    public Order(User user, Map<Product, Integer> products, Warehouse warehouse, String count) {
        this.products = products;
        this.user = user;
        this.warehouse = warehouse;
        this.count = count;
        this.warehouse.addOrder(this);
        doingOrder();
    }

    private void doingOrder() {
        if (this.count.equals("last")) {
            while (warehouse.getQueueSize() > 0) {
                this.warehouse.processing();
            }
        }
    }

    public Map<Product, Integer> getProducts(){
        return this.products;
    }

    public User getUser(){
        return this.user;
    }
}
