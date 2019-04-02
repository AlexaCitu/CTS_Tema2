package ro.ase.cts.models;

import ro.ase.cts.utils.InvalidNrOfPagesException;

public class Book {
	private String title;
	private double price;
	private int page;
	private BookType type;
	
	public Book() {
		
	}

	public Book(String title, double price, int pageNumber, BookType type) {
		super();
		this.title = title;
		this.price = price;
		this.page = pageNumber;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPageNumber() {
		return page;
	}

	public void setPageNumber(int pageNumber) {
		this.page = pageNumber;
	}

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}
	
	public void maxPageNr() throws InvalidNrOfPagesException{
		if(this.page>=Integer.MAX_VALUE) {
			throw new InvalidNrOfPagesException("Too many pages!");
		}
	}
	

}
