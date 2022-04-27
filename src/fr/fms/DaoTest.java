package fr.fms;

import java.util.Arrays;
import java.util.List;

import fr.fms.dao.DaoBookImpl;
import fr.fms.dao.DaoCustomerImpl;
import fr.fms.dao.DaoFactory;
import fr.fms.dao.DaoOrderDetailImpl;
import fr.fms.dao.DaoOrderImpl;
import fr.fms.dao.DaoThemeImpl;
import fr.fms.entities.Book;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderDetail;
import fr.fms.entities.Theme;

public class DaoTest {

	public static void main(String[] args) {
		
		DaoBookImpl bookDao = DaoFactory.getBookDao();
		DaoCustomerImpl userDao = DaoFactory.getCustomerDao();
		DaoOrderImpl orderDao = DaoFactory.getOrderDao();
		DaoOrderDetailImpl orderDetailDao = DaoFactory.getOrderDetailDao();
		DaoThemeImpl themeDao = DaoFactory.getThemeDao();
		
		// BOOKS
		
		// READ BY THEME => OK
		//bookDao.readAllByTheme(2).stream().forEach(book -> System.out.println(book));
		//formatData();
		
		// READ BY USED => OK
		//bookDao.readAllByUsed(true).stream().forEach(book -> System.out.println(book));
		
		// READ ALL => OK
		//bookDao.readAll().stream().forEach(book -> System.out.println(book));
		
		// READ BY ID => OK
		//System.out.println(bookDao.read(10));
		
		// DELETE BY ID => OK
		//bookDao.delete(10);
		
		// UPDATE => OK
		//bookDao.update(new Book(1, "AIRBUS", "Guide aviation", "Sebastien", (float) 15.99, true));
		
		// CREATE => OK
		//bookDao.create(new Book("Elevation","On lui doit plus de cinquante romans et autant de nouvelles","Stephen King", (float) 34.99, false));
		
		// CUSTOMERS
		
		// READ ALL => OK
		//userDao.readAll().stream().forEach(customer -> System.out.println(customer));
		
		// READ BY ID => OK
		//System.out.println(userDao.read(3));
		
		// DELETE BY ID => OK
		//userDao.delete(1);
		
		// UPDATE BY ID => OK
		//userDao.update(new Customer(1, "Evie", "Rookwell", "erookwell1@a8.net", "H5ed", "7297091149", "0166 Northport Street"));
		
		// CREATE => OK
		//userDao.create(new Customer("Maurie","Wandrack","mwandrack3@simplemachines.org	", "azerty", "6628997719", "2 Victoria Place"));
		
		// ORDERS
		
		// READ ALL => OK
		//orderDao.readAll().stream().forEach(order -> System.out.println(order));
		
		// READ BY ID => OK
		//System.out.println(orderDao.read(3));
		
		// DELETE => OK
		//orderDao.delete(3);
		
		// UPDATE => OK
		//orderDao.update(new Order(2, (float) 568.47, 2));
		
		// CREATE => OK
		//orderDao.create(new Order((float) 219.88, 3));
		
		// ORDER DETAIL
		
		// READ ALL => OK
		//orderDetailDao.readAll().stream().forEach(orderDetail -> System.out.println(orderDetail));
		
		// READ BY ID => OK
		//System.out.println(orderDetailDao.read(3));
		
		// DELETE => OK
		//orderDetailDao.delete(4);
		
		// UPDATE => OK
		//orderDetailDao.update(new OrderDetail(2, 2, 1, 54, 4));
		
		// CREATE => OK
		//orderDetailDao.create(new OrderDetail(2, 1, 26, 12));
		
		// THEME
		
		// READ ALL => OK
		//themeDao.readAll().stream().forEach(theme -> System.out.println(theme));
		
		// READ BY ID => OK
		//System.out.println(themeDao.read(2));
		
		// DELETE => OK
		//themeDao.delete(8);
		
		// UPDATE => OK
		//themeDao.update(new Theme(10, "cours d'anglais"));
		
		// CREATE =>
		//themeDao.create(new Theme("comics"));
		
	}

}
