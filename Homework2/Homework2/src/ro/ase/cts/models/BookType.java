package ro.ase.cts.models;

public enum BookType {
	FANTASY("FANTASY"),
	DRAMA("DRAMA"),
	CRIME("CRIME"), 
	HISTORY("HISTORY"),
	ROMANCE("ROMANCE");
	
	private String bookTitle;

	private BookType(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	

}
