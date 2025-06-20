import java.util.*;

public class Warehouse {
    private Point location;
    private Map<Product, Integer> stocks  = new HashMap<>();
    private Supplier supplier;
    protected ArrayList<Courier> couriers = new ArrayList<>();
    protected ArrayList<Storekeeper> storekeepers = new ArrayList<>();
    private Queue<Order> orderQueue = new ArrayDeque<>();

    public Warehouse(Point location, Supplier supplier){
        this.location = location;
        this.supplier = supplier;
    }

    public void orderSupplies(Map<Product, Integer> orderList){
        Map<Product, Integer> delivered = supplier.deliver(orderList);
        for (var tmp : delivered.entrySet()){
            stocks.put(tmp.getKey(), stocks.get(tmp.getKey()) == null ? tmp.getValue() : tmp.getValue() +
                    stocks.get(tmp.getKey()));
        }
    }

    public void processing(){
        Order orderTmp = orderQueue.poll();
        for (var tmp : storekeepers){
            if(!tmp.getBusy() && tmp.getShift()){
                tmp.setBusy(true);
                tmp.prepareProduct(orderTmp.getProducts(), stocks);
                tmp.setBusy(false);
            }
        }
        for (var tmp : couriers){
            if(!tmp.getBusy() && tmp.getShift()){
                tmp.setBusy(true);
                tmp.deliver(orderTmp.getUser().getLocation());
                tmp.setBusy(false);

            }
        }
    }

    public void addCourier(Courier other){
        other.setWarehouse(this);
        this.couriers.add(other);
    }

    public void addStorekeeper(Storekeeper other){
        other.setWarehouse(this);
        this.storekeepers.add(other);
    }

    public void addOrder(Order other){
        other.setWarehouse(this);
        this.orderQueue.add(other);
        if(other.getCount().equals("last")){
            other.doingOrder();
        }
    }

    public Map<Product, Integer> getStocks() {
        return stocks;
    }

    public Point getLocation(){
        return location;
    }

    public int getQueueSize(){
        return this.orderQueue.size();
    }
}
