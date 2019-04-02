package ro.ase.cts.tests;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.utils.BookDB;

public class BookDBTest {
	
	@BeforeClass
	public static void connect() {
		try {
			BookDB.connect("test", "test");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@AfterClass
	public static void disconnectDB() {
		BookDB.closeDB("test", "test");
	}
	
	@Test
	public void testSize() {
		System.out.println(BookDB.bookTitles.size());
	}
	

}
