package ro.ase.cts.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ro.ase.cts.models.Book;
import ro.ase.cts.models.BookType;

public class BookDB {
	
	public static List<Book> bookTitles;
	
	public static void connect(String user, String psw) throws IOException{
		bookTitles= new ArrayList<Book>();
		BufferedReader reader = new BufferedReader(new
				FileReader("books.txt"));
		String line= "";
		
		while((line=reader.readLine())!=null) {
			String[] values= line.split(",");
			Book b= new Book(values[0],
					Double.parseDouble(values[1]),
					Integer.parseInt(values[2]),
					BookType.valueOf(values[3]));
			bookTitles.add(b);
		}
		reader.close();
		System.out.println("Connected");
	}
	public static void closeDB(String user, String psw) {
		bookTitles.removeAll(bookTitles);
	}
	
}
