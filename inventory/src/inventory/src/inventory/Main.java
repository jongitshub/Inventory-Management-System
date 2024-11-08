package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		Inventory products = new Inventory();
		
		
		System.out.println("1. Add a product");
		System.out.println("2. Remove a product");
		String question = scan.nextLine();
		
		
		switch(question) {
		case"1":
			int id = random.nextInt(10000);
			System.out.println("enter the product's name");
			String name = scan.nextLine();
			System.out.println("enter the quantity");
			int qty = scan.nextInt();
			products.addProduct(id, name, qty);
			System.out.println(id + "\n is the product's id");
			try {
				// Load the driver for mysql
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost:3306/products";
				String username = "root";
				String password = "";
				Connection conn = DriverManager.getConnection(url, username, password);
				System.out.println("Connected successfully!");
				
				// Create a statement
				PreparedStatement ps = conn.prepareStatement("INSERT INTO products_table (id, name, quantity) VALUES (?, ?, ?)");
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, qty);
				// perform insert
				ps.executeUpdate();
				
			}catch (Exception ex){
				ex.printStackTrace();
			}
			break;
		case"2":
			System.out.println("Do you know the product id?\n "
					+ "y for yes, n for no ");
			String res = scan.nextLine();
			if (res == "y") {
				System.out.println("Enter the numerical id: ");
				int entered_id = scan.nextInt();
				products.removeProduct(entered_id);
				System.out.println("Product "+ entered_id + "has been removed.");
			}
		}
	}
}
