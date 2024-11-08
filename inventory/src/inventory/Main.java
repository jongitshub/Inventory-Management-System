package inventory;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		Inventory products = new Inventory();
		
		
		System.out.println("1. Add a product");
		String question = scan.nextLine();
		
		
		switch(question) {
		case"1":
			int id = random.nextInt(10000);
			System.out.println("enter the product's name");
			String name = scan.nextLine();
			System.out.println("enter the quantity");
			int qty = scan.nextInt();
			products.addProduct(id, name, qty);
			System.out.println(id + "/n is the product's id");
		}
	}
}
