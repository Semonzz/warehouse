import java.util.Map;

public class Storekeeper extends Worker {

    public Storekeeper(int id, String name){
        super(id, name);

    }

    public void prepareProduct(Map<Product, Integer> products, Map<Product, Integer> stocks){
        System.out.println("Storekeeper starts preparing supplies....");
        double tmpTime = 0;

        for (var orderEntry : products.entrySet()) {
            Product orderedProduct = orderEntry.getKey();
            int orderedQty = orderEntry.getValue();

            for (var stockEntry : stocks.entrySet()) {
                Product stockProduct = stockEntry.getKey();

                if (orderedProduct.getName().equals(stockProduct.getName())) {
                    int stockQty = stockEntry.getValue();

                    if (stockQty >= orderedQty) {
                        stocks.put(stockProduct, stockQty - orderedQty);
                        tmpTime += 0.75;
                    }
                    else if (stockQty <= orderedQty && stockQty != 0) {
                        tmpTime += 0.75;
                        stocks.put(stockProduct, 0);
                    }
                    break;
                }
            }
        }
        inWork += tmpTime;
        System.out.println("\nStorekeeper prepare product for " + tmpTime + " minutes");
        checkTimeWork();
    }

}
