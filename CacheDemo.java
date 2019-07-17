package com.concretepage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CacheDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		BookApp bookApp = ctx.getBean(BookApp.class);
		int id = 10;
		//Calling getBook method first time for an id.
		System.out.println(bookApp.getBook(id).getName());
		//Calling getBook method second time for same id.
		//This time, method will not execute because result is cached with "mycache" for that id.
		System.out.println(bookApp.getBook(id).getName());
		//Calling updateBook method to change cache value for that id.
        bookApp.updateBook(id, "Ramayan");
		//Calling getBook method again for that id. Method will not execute but cache value will change.
		System.out.println(bookApp.getBook(id).getName());
		ctx.close();
	}
}
