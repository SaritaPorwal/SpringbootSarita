package com.springrest.awscrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return service.getBooks();
	}
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id)
	{
		return service.getBookById(id);
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
	   return service.saveBook(book);
	}
	
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> book)
	{
	   return service.saveBooks(book);
	}

	@PatchMapping("/updateBook")
	public Book updateBook(@RequestBody Book book)
	{
		return service.updateBook(book);
	}
	@DeleteMapping("/deleteBook/{id}")
	public boolean deleteBook(@PathVariable int id)
	{
		return service.deleteBook(id);
	}
}
