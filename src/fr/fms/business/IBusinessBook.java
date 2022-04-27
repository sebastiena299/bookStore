package fr.fms.business;

import java.util.List;

import fr.fms.dao.Dao;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Book;

public interface IBusinessBook {
	
	public Dao<Book> bookDao = DaoFactory.getBookDao();
	
	public List<Book> getAllBooks();
	public Book getBookById(int id);
	public boolean createBook(Book book);
	public boolean updateBook(Book book);
	public boolean deleteBook(int id);

}
