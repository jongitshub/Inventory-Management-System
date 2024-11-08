package inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public boolean addProduct(int id, String name, int qty) {
        if (this.products.containsKey(id)) {
        	return false;
        }else {
        	this.products.put(id, new Product(id, name, qty));
        	boolean check = this.products.containsKey(id);
            System.out.println("product added successfully");
            System.out.println(check);
            return true;
        }
    }
    

    // ... other methods
}
