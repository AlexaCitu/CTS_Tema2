package ro.ase.cts.models;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
	private List<Book> books;
	private double purchasePrice;
	private boolean discount;
	
	public Purchase() {
		this.books= new ArrayList<>();
	}
	
	public void addProduct(Book b) {
		this.books.add(b);
	}
	
	public void removeProduct(Book b) {
		this.books.remove(b);
	}
	
	public double getSum() {
		double price= 0;
		for(Book b: this.books) {
			price+= b.getPrice();
		}
		return price;
	}
	
	public String viewPurchase() {
		StringBuilder builder= new StringBuilder();
		for(Book b: this.books) {
			builder.append(b.getTitle()+" "+
		b.getPrice()+" "+ b.getPageNumber()+" "+ 
					b.getType()+"\n");
		}
		builder.append("TOTAL: "+ this.getSum());
		
		return builder.toString();
	}

}
