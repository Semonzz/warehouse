import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    @Test
    void testSalary() {
        Supplier supplier = new Supplier("Sup 1");
        Warehouse warehouse = new Warehouse(new Point(1, 1), supplier);

        Map<Product, Integer> supplyOrder = new HashMap<>();
        supplyOrder.put(new Product(1, "Product A"), 100);
        supplyOrder.put(new Product(2, "Product B"), 50);
        supplyOrder.put(new Product(3, "Product C"), 25);

        warehouse.orderSupplies(supplyOrder);

        Courier c = new Courier(1,"Courier 1", warehouse);
        Storekeeper s = new Storekeeper(1, "Storekeeper 1", warehouse);

        User newUser = new User("Test user", new Point(1, 20));

        Map<Product, Integer> newOrder = new HashMap<>();
        newOrder.put(new Product(1, "Product A"), 50);
        newOrder.put(new Product(2, "Product B"), 25);
        newOrder.put(new Product(3, "Product C"), 25);

        Order order1 = new Order(newUser, newOrder, warehouse, "last");
        assertEquals(s.getSalary(), 11.25);
        assertEquals(c.getSalary(), 105);
    }

    @Test
    void testTime(){
        Supplier supplier = new Supplier("Sup 1");
        Warehouse warehouse = new Warehouse(new Point(1, 1), supplier);

        Map<Product, Integer> supplyOrder = new HashMap<>();
        supplyOrder.put(new Product(1, "Product A"), 100);
        supplyOrder.put(new Product(2, "Product B"), 50);
        supplyOrder.put(new Product(3, "Product C"), 25);

        warehouse.orderSupplies(supplyOrder);

        Courier c = new Courier(1,"Courier 1", warehouse);
        Storekeeper s = new Storekeeper(1, "Storekeeper 1", warehouse);

        User newUser = new User("Test user", new Point(1, 20));
        User newUser1 = new User("Test user 1", new Point(1, 23));

        Map<Product, Integer> newOrder = new HashMap<>();
        newOrder.put(new Product(1, "Product A"), 50);
        newOrder.put(new Product(2, "Product B"), 25);
        newOrder.put(new Product(3, "Product C"), 25);

        Order order1 = new Order(newUser1, newOrder, warehouse, "");
        Order order = new Order(newUser, newOrder, warehouse, "last");
        assertEquals(s.getInWork(), 3.75);
        assertEquals(c.getInWork(), 45);
    }
}
