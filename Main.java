import java.util.*;

public class Main {
    public static void main(String[] args) {
        Supplier supplier = new Supplier("Sup 1");
        Warehouse warehouse = new Warehouse(new Point(1, 1), supplier);

        Map<Product, Integer> supplyOrder = new HashMap<>();
        supplyOrder.put(new Product(1, "Product A"), 100);
        supplyOrder.put(new Product(2, "Product B"), 50);
        supplyOrder.put(new Product(3, "Product C"), 25);

        warehouse.orderSupplies(supplyOrder);
        System.out.println(warehouse.getStocks());

        Courier c = new Courier(1,"Courier 1", warehouse);
        //Courier c1 = new Courier(1,"Courier 2", warehouse);
        Storekeeper s = new Storekeeper(1, "Storekeeper 1", warehouse);
        //Storekeeper s1 = new Storekeeper(1, "Storekeeper 2", warehouse);

        User newUser = new User("Test user", new Point(1, 20));
        User newUser1 = new User("Test user 1", new Point(1, 23));

        Map<Product, Integer> newOrder = new HashMap<>();
        newOrder.put(new Product(1, "Product A"), 50);
        newOrder.put(new Product(2, "Product B"), 25);
        newOrder.put(new Product(3, "Product C"), 25);

        Order order1 = new Order(newUser, newOrder, warehouse, "");
        Order order2 = new Order(newUser1, newOrder, warehouse, "last");

    }
}