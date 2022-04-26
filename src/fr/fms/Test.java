package fr.fms;

import fr.fms.dao.DaoBookImpl;
import fr.fms.dao.DaoCustomerImpl;
import fr.fms.entities.Book;
import fr.fms.entities.Customer;

public class Test {

	public static void main(String[] args) {
		
		DaoBookImpl shop = new DaoBookImpl();
		DaoCustomerImpl userDao = new DaoCustomerImpl();
		
		// BOOKS
		
		// READ ALL => OK
		//shop.readAll().stream().forEach(book -> System.out.println(book));
		
		// READ BY ID => OK
		//System.out.println(shop.read(10));
		
		// DELETE BY ID => OK
		//shop.delete(10);
		
		// UPDATE => OK
		//shop.update(new Book(1, "AIRBUS", "Guide aviation", "Sebastien", (float) 15.99, true));
		
		// CREATE => OK
		//shop.create(new Book("Elevation","On lui doit plus de cinquante romans et autant de nouvelles","Stephen King", (float) 34.99, false));
		
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
	}

}
