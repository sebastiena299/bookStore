package fr.fms.dao;

import java.sql.Connection;
import java.util.List;

import fr.fms.entities.Book;

public interface Dao<T> {
	
	public Connection connection = BddConnection.getConnection();
	public void create(Book book);
	public void update(Book book);
	public void delete(int id);
	public T read(int id);
	public List<Book> readAll();

}
