package fr.fms.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.Theme;

public class IBusiness implements IBusinessBook, IBusinessCustomer, IBusinessOrder, IBusinessOrderDetail, IBusinessTheme {
	
	private static HashMap<Integer, Book> cart = new HashMap<Integer, Book>();
	
	/**
	 * Checks that the user is in the database
	 * @param email
	 * @param password
	 * @return Customer for active session
	 */
	public Customer authentification(String email, String password) {
		List<Customer> customers = customerDao.readAll();
		for(Customer customer : customers) {
			if(customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
				return customer;
			}
		}
		return null;
	}
	
	/**
	 * Return the shopping cart
	 * @return
	 */
	public HashMap<Integer, Book> getCart() {
		return cart;
	}
	
	/**
	 * Returns the total of the shopping cart
	 * @return total amount of cart
	 */
	public float getTotalCart() {
		float sum = 0;
		for(Entry<Integer, Book> entry : cart.entrySet()) {
			sum += (entry.getValue().getPrice() * entry.getValue().getQuantity());
		}
		return sum;
	}
	
	/**
	 * Add a book to the shopping cart
	 * @param book
	 * @return
	 */
	public boolean addBookTocart(Book book) {
		Book bk = cart.get(book.getId());
		if(bk != null) {
			bk.setQuantity(bk.getQuantity() + 1);
			return true;
		} else {
			cart.put(book.getId(), book);
			return true;
		}
	}
	
	/**
	 * Remove a book to the shopping cart
	 * @param book id 
	 * @return
	 */
	public boolean removeBookToCart(int id) {
		Book bk = cart.get(id);
		if(bk.getQuantity() > 1) {
			bk.setQuantity(bk.getQuantity() - 1);
			return true;
		} else {
			cart.remove(id);
			return true;
		}
	}
	
	/**
	 * Delete the shopping cart
	 */
	public void clearCart() {
		cart.clear();
	}
	
	/**
	 * Return all books if they are used or not
	 */
	@Override
	public List<Book> getAllBooksByUsed(boolean used) {
		return bookDao.readAllByUsed(used);
	}
	
	/**
	 * Return all books by theme
	 */
	@Override
	public List<Book> getAllBooksByTheme(int id) {
		return bookDao.readAllByTheme(id);
	}

	/**
	 * Return all books
	 */
	@Override
	public List<Book> getAllBooks() {
		return bookDao.readAll();
	}

	/**
	 * Return a book by id
	 */
	@Override
	public Book getBookById(int id) {
		return bookDao.read(id);
	}

	/**
	 * Create a book
	 */
	@Override
	public boolean createBook(Book book) {
		return bookDao.create(book);
	}

	/**
	 * Update a book
	 */
	@Override
	public boolean updateBook(Book book) {
		return bookDao.update(book);
	}

	/**
	 * Delete a book
	 */
	@Override
	public boolean deleteBook(int id) {
		return bookDao.delete(id);
	}

	/**
	 * Return all customers
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.readAll();
	}

	/**
	 * Return customer by id
	 */
	@Override
	public Customer getCustomerById(int id) {
		return customerDao.read(id);
	}

	/**
	 * Create a customer
	 */
	@Override
	public boolean createCustomer(Customer customer) {
		return customerDao.create(customer);
	}

	/**
	 * Update a customer
	 */
	@Override
	public boolean updateCustomer(Customer customer) {
		return customerDao.update(customer);
	}

	/**
	 * Delete a customer
	 */
	@Override
	public boolean deleteCustomer(int id) {
		return customerDao.delete(id);
	}

	/**
	 * Return all orders
	 */
	@Override
	public List<Order> getAllOrders() {
		return orderDao.readAll();
	}

	/**
	 * Return order by id
	 */
	@Override
	public Order getOrderById(int id) {
		return orderDao.read(id);
	}

	/**
	 * Create an order and order detail
	 * @param id - Customer id
	 */
	@Override
	public boolean createOrder(int id) {
		float total = getTotalCart();
		Order order = new Order(total, id);
		if(orderDao.create(order)) {
			for(Book book : cart.values()) {
				orderDetailDao.create(new OrderDetail(order.getId(), book.getId(), book.getPrice(), book.getQuantity()));
			}
			return true;
		}
		return false;
	}

	/**
	 * Update an order
	 */
	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Delete an order
	 */
	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Return all orderDetails
	 */
	@Override
	public List<OrderDetail> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return orderDetail by id
	 */
	@Override
	public OrderDetail getOrderDetailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create order²Detail
	 */
	@Override
	public boolean createOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Update orderDetail
	 */
	@Override
	public boolean updateOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Delete OrderDetail
	 */
	@Override
	public boolean deleteOrderDetail(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Return all themes
	 */
	@Override
	public List<Theme> getAllThemes() {
		return themeDao.readAll();
	}

	/**
	 * Return theme by id
	 */
	@Override
	public Theme getThemeById(int id) {
		return themeDao.read(id);
	}

	/**
	 * Create a theme
	 */
	@Override
	public boolean createTheme(Theme theme) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Update a theme
	 */
	@Override
	public boolean updateTheme(Theme theme) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Delete a theme
	 */
	@Override
	public boolean deleteTheme(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
