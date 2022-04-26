package fr.fms.dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import fr.fms.entities.Book;

public interface Dao<T> {
	
	public Connection connection = BddConnection.getConnection();
	public static final Logger logger = Logger.getLogger( "SqlExceptions" );
	public boolean create(Book book);
	public boolean update(Book book);
	public boolean delete(int id);
	public T read(int id);
	public List<Book> readAll();

}
