package com.concretepage;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookApp {
	@CachePut(value = "mycache", key="#id")
	public Book updateBook(int id, String bookName) {
		System.out.println("Executing updateBook method...");	
		Book book = new Book();
		book.setId(id);
		book.setName(bookName);
		return book;
	}
	@Cacheable(value = "mycache", key="#id")
	public Book getBook(int id) {
		System.out.println("Executing getBook method...");
		Book book = new Book();
		book.setId(id);		
		book.setName("Mahabharat");
		return book;
	}
}