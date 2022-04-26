package fr.fms.dao;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

public interface Dao<T> {
	
	public Connection connection = BddConnection.getConnection();
	public static final Logger logger = Logger.getLogger( "SqlExceptions" );
	public boolean create(T ojb);
	public boolean update(T obj);
	public boolean delete(int id);
	public T read(int id);
	public List<T> readAll();

}
