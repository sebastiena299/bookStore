package fr.fms;

import fr.fms.dao.DaoBookImpl;
import fr.fms.entities.Book;

public class Test {

	public static void main(String[] args) {
		
		DaoBookImpl shop = new DaoBookImpl();
		
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
	}

}
