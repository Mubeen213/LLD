package VendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    private Map<Product, Integer> products;

    public Inventory() {
        products = new ConcurrentHashMap<>();
    }

    public void addOrRestockProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public boolean isAvailable(Product product) {
        return (products.containsKey(product) && products.get(product) > 0);
    }

    public void dispenseProduct(Product product) throws Exception {
        if (!isAvailable(product)) {
            throw new Exception("Product is currently not available");
        }
        Integer currentStock = products.get(product);
        products.put(product, currentStock - 1);
    }

   public int getProductStock(Product product) {
        return products.getOrDefault(product, 0);
   }

   public void displayAvailableStock() {
        products.forEach((p, s) -> {
            System.out.println("Product " + p + " and quantity " + s);
        });
   }



}
