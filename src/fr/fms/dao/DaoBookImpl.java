package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import fr.fms.entities.Book;

public class DaoBookImpl implements Dao<Book> {
	
	/**
	 * 
	 * @param theme
	 * @return List object of type Book
	 * @exception SQLException in case of an error related to a query
	 */
	public List<Book> readAllByTheme(int theme) {
		String query = "SELECT books.id, books.title, books.description, books.author, books.price, books.usedBook "
				+ "FROM books, book_themes, themes "
				+ "WHERE books.id = book_themes.idBook "
				+ "AND book_themes.idTheme = themes.id "
				+ "AND book_themes.idTheme = ?";
		List<Book> books = new ArrayList<Book>();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, theme);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				book.setUsedBook(rs.getBoolean("usedBook"));
				books.add(book);
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read books by theme");
		}
		return books;
	}
	
	/**
	 * @param Boolean to know if the book is used
	 * @return List object of type Book
	 * @exception SQLException in case of an error related to a query
	 */
	public List<Book> readAllByUsed(boolean used) {
		String query = "SELECT * FROM books WHERE usedBook = ?";
		List<Book> books = new ArrayList<Book>();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setBoolean(1, used);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				book.setUsedBook(rs.getBoolean("usedBook"));
				books.add(book);
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read used or not used books");
		}
		return books;
	}

	/**
	 * @param Object of type Book
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean create(Book book) {
		String query = "INSERT INTO books (title, description, author, price, usedBook) VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getAuthor());
			ps.setFloat(4, book.getPrice());
			ps.setBoolean(5, book.isUsedBook());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when creating a book");
		}
		return false;
	}

	/**
	 * @param Object of type Book
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean update(Book book) {
		String query = "UPDATE books SET title = ?, description = ?, author = ?, price = ?, usedBook = ? WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getDescription());
			ps.setString(3, book.getAuthor());
			ps.setFloat(4, book.getPrice());
			ps.setBoolean(5, book.isUsedBook());
			ps.setInt(6, book.getId());
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when updating a book");
		}
		return false;
	}

	/**
	 * @param Identifier of the book to be deleted
	 * @return Boolean to know if the operation was successful
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM books WHERE id = ?";
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			if(ps.executeUpdate() == 1) return true;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when delete a book");
		}
		return false;
	}

	/**
	 * @param Identifier of the book to be displayed
	 * @return Object of type Book
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public Book read(int id) {
		String query = "SELECT * FROM books WHERE id = ?";
		Book book = new Book();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setDescription(rs.getString("description"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getFloat("price"));
			book.setUsedBook(rs.getBoolean("usedBook"));
			return book;
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when read a book");
		}
		return null;
	}

	/**
	 * @return List object of type Book
	 * @exception SQLException in case of an error related to a query
	 */
	@Override
	public List<Book> readAll() {
		String query = "SELECT * FROM books";
		List<Book> books = new ArrayList<Book>();
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setDescription(rs.getString("description"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				book.setUsedBook(rs.getBoolean("usedBook"));
				books.add(book);
			}
			
		} catch(SQLException e) {
			logger.log(Level.SEVERE, " Problem when real All books");
		}
		return books;
	}
	
	

}
