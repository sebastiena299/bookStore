package fr.fms.dao;

import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.Theme;

public class DaoFactory {
	
	public static Dao<Book> getBookDao() {
		return new DaoBookImpl();
	}
	
	public static Dao<Customer> getCustomerDao() {
		return new DaoCustomerImpl();
	}
	
	public static Dao<Order> getOrderDao() {
		return new DaoOrderImpl();
	}
	
	public static Dao<OrderDetail> getOrderDetailDao() {
		return new DaoOrderDetailImpl();
	}
	
	public static Dao<Theme> getThemeDao() {
		return new DaoThemeImpl();
	}

}
