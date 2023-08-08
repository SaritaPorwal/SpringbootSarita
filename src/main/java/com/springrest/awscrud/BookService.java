package com.springrest.awscrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {
	@Autowired
	BookRepository repository;
	
	public Book saveBook(Book st)
	{
		return repository.save(st);
	}
	
	public List<Book> saveBooks(List<Book> st)
	{
		return repository.saveAll(st);
	}

	public List<Book> getBooks()
	{
		return repository.findAll();
	}
	
	public Book getBookById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public Book updateBook(Book b)
	{
		Book st1=repository.findById(b.getBookId()).get();
		st1.setBookName(b.getBookName());
		st1.setBookAuthor(b.getBookAuthor());
		st1.setPrice(b.getPrice());
		
		return repository.save(st1);
	}
	public boolean deleteBook(int id)
	{
		Book st1=repository.findById(id).get();
		repository.delete(st1);
		return true;
		
	
	}
}
