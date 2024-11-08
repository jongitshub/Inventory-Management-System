package inventory;

import java.io.Serializable;

public class Product implements Serializable {
	
	private int id;
	private String name;
	private int qty;

	public Product(int id, String name, int qty) {
		this.id = id;
		this.name = name;
		this.qty = qty;				
	}
}
