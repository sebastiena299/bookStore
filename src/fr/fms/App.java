package fr.fms;

import java.util.Scanner;

import fr.fms.business.IBusiness;
import fr.fms.entities.Customer;

public class App {
	
	private static IBusiness shop = new IBusiness();
	
	private static final String R = "\u001B[0m";
	private static final String C = "\u001B[36m";
	
	private static Scanner scan = new Scanner(System.in);
	private static int choice;
	private static final Customer selectedCustomer = null;
	
	/**
	 * Displays the menus available in the application
	 */
	public static void displayMenu() {
		System.out.println(" [" + C + "1" + R + "] -> " + C + "📕" + R + " Afficher tous les livres");
		System.out.println(" [" + C + "2" + R + "] -> " + C + "📕" + R + " Afficher tous les livres par themes");
		System.out.println(" [" + C + "3" + R + "] -> " + C + "🛒" + R + " Ajouter un livre au panier");
		System.out.println(" [" + C + "4" + R + "] -> " + C + "🛒" + R + " Supprimer un livre au panier");
		System.out.println(" [" + C + "5" + R + "] -> " + C + "🛒" + R + " Vider le panier");
		System.out.println(" [" + C + "6" + R + "] -> " + C + "📦" + R + " Passer commande");
		if(selectedCustomer != null ) {
			System.out.println(" [" + C + "7" + R + "] -> " + C + "🔒" + R + " Déconnexion");
		} else {
			System.out.println(" [" + C + "8" + R + "] -> " + C + "🔒" + R + " Connexion");
		}
		System.out.println(" [" + C + "9" + R + "] -> " + C + "⛔" + R + " Sortir");
		System.out.print("\n Saisir le menu [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		choiceMenu(scan.nextInt());
	}
	
	public static void displayTypesOfBook() {
		System.out.println("\n [" + C + "1" + R + "] -> " + C + "📕" + R + " Afficher tous les livres");
		System.out.println(" [" + C + "2" + R + "] -> " + C + "📕" + R + " Afficher tous les livres neufs");
		System.out.println(" [" + C + "3" + R + "] -> " + C + "📕" + R + " Afficher tous les livres d'occasion");
		System.out.print("\n Saisir le menu [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		choiceTypesOfBook(scan.nextInt());
	}
	
	public static void choiceTypesOfBook(int choice) {
		switch (choice) {
		case 1:
			Utils.formatDataBook(shop.getAllBooks());
			break;
		case 2:
			Utils.formatDataBook(shop.getAllBooksByUsed(false));
			break;
		case 3:
			Utils.formatDataBook(shop.getAllBooksByUsed(true));
			break;
		default:
			displayTypesOfBook();
			break;
		}
	}
	
	/**
	 * Redirects the user according to his choice
	 * @param choice
	 */
	public static void choiceMenu(int choice) {
		switch (choice) {
		case 1:
			displayTypesOfBook();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		
		while(choice != 9) displayMenu();
		
	}

}
