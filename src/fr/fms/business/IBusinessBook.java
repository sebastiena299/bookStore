package fr.fms.business;

import java.util.List;

import fr.fms.dao.DaoBookImpl;
import fr.fms.dao.DaoFactory;
import fr.fms.entities.Book;

public interface IBusinessBook {
	
	public DaoBookImpl bookDao = DaoFactory.getBookDao();
	
	public List<Book> getAllBooks();
	public List<Book> getAllBooksByUsed(boolean used);
	public List<Book> getAllBooksByTheme(int id);
	public Book getBookById(int id);
	public boolean createBook(Book book);
	public boolean updateBook(Book book);
	public boolean deleteBook(int id);

}
