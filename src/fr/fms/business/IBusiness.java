package fr.fms.business;

import java.util.HashMap;
import java.util.List;

import fr.fms.entities.Book;
import fr.fms.entities.Customer;

public class IBusiness implements IBusinessBook, IBusinessCustomer {
	
	private static HashMap<Integer, Book> cart;
	
	@Override
	public List<Book> getAllBooksByUsed(boolean used) {
		return bookDao.readAllByUsed(used);
	}
	
	@Override
	public List<Book> getAllBooksByTheme(int id) {
		return bookDao.readAllByTheme(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.readAll();
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.read(id);
	}

	@Override
	public boolean createBook(Book book) {
		return bookDao.create(book);
	}

	@Override
	public boolean updateBook(Book book) {
		return bookDao.update(book);
	}

	@Override
	public boolean deleteBook(int id) {
		return bookDao.delete(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.readAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.read(id);
	}

	@Override
	public boolean createCustomer(Customer customer) {
		return customerDao.create(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public boolean deleteCustomer(int id) {
		return customerDao.delete(id);
	}

}
