package ro.ase.cts.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.models.Book;
import ro.ase.cts.models.BookType;
import ro.ase.cts.models.Purchase;
import ro.ase.cts.utils.BookDB;
import ro.ase.cts.utils.InvalidNrOfPagesException;

public class PurchaseTest {
	
	private Purchase purchase;
	private List<Book> books;
	
	@BeforeClass
	public static void beforeAll() {
		try {
			BookDB.connect("admin", "password");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() {
		purchase= new Purchase();
		books= new ArrayList<Book>();
	}
	
	@AfterClass
	public static void afterAll() {
		try {
			BookDB.connect("admin", "password");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//Conformance 
		@Test
		public void testNumberPages() {
			Book book= new Book("Mara", 40.0,200,BookType.DRAMA);
			assertEquals(book.getPageNumber(), 200);
		}
		
	//order
		@Test
		public void testPrintBooks() {
			Book b1= new Book("Mara", 40.0,200,BookType.DRAMA);
			Book b2= new Book("Jules Verne", 60.0, 400, BookType.FANTASY);
			String value= String.format("%s\n%s\n%s",
					b1.getTitle()+" "+b1.getPrice()+" "+
					b1.getPageNumber()+ " "+ b1.getType(),
					b2.getTitle()+" "+b2.getPrice()+" "+
							b2.getPageNumber()+ " "+ b2.getType(),"TOTAL: 100.0");
			this.purchase.addProduct(b1);
			this.purchase.addProduct(b2);
			assertEquals(value, this.purchase.viewPurchase());
		}
		
	//right
		@Test
		public void testPrintPurchasedBook() {
			Book b = new Book("Chasing the Sun",
					70.0,300,BookType.ROMANCE);
			this.purchase.addProduct(b);
			String value= String.join("\n", 
					b.getTitle()+" "+
							b.getPrice()+" "+
							b.getPageNumber()+ " "+
							b.getType(), "TOTAL: 70.0");
			assertEquals(value, this.purchase.viewPurchase());
		}
	
	//range
		@Test
		public void testRange() {
			Book b = new Book("Chasing the Sun",
					70.0,300,BookType.ROMANCE);
			this.books.add(b);
			assertEquals(1, books.size());
		}
	
	@Test
	public void testType() {
		Book book= new Book("Jules Verne", 60.0, 400, BookType.FANTASY);
		assertEquals(book.getType(), BookType.FANTASY);
	}
	//Existence
	@Test
	public void testPrice() {
		Book book= new Book("Rome", 70.0, 200, BookType.HISTORY);
		assertNotNull(book.getPrice());
	}
	
	//boundary 
	
	@Test
	public void testMaxNrPages() {
		Book book= new Book("Rome", 70.0, 200, BookType.HISTORY);
		book.setPageNumber(Integer.MAX_VALUE);
		try {
			book.maxPageNr();
			fail("Number of pages is too large!");
		}catch(InvalidNrOfPagesException e){
			e.getMessage();
		}
	}
	
}
