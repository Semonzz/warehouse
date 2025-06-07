import java.util.*;

public class Supplier {
    private String name;

    public Supplier(String name){
        this.name = name;
    }

    public Map<Product, Integer> deliver(Map<Product, Integer> requested) {
        return new HashMap<>(requested);
    }
}
