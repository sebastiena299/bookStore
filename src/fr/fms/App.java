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
	private static Customer selectedCustomer = null;
	
	/**
	 * Displays the menus available in the application
	 */
	public static void displayMenu() {
		System.out.println(C + " ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬" + R);
		System.out.println("\t Book Store " + displayUser());
		System.out.println(C + " ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬" + R);
		System.out.println(" [" + C + "1" + R + "] -> " + C + "📕" + R + " Afficher tous les livres");
		System.out.println(" [" + C + "2" + R + "] -> " + C + "📕" + R + " Afficher les themes");
		System.out.println(" [" + C + "3" + R + "] -> " + C + "🛒" + R + " Ajouter un livre au panier");
		System.out.println(" [" + C + "4" + R + "] -> " + C + "🛒" + R + " Supprimer un livre au panier");
		System.out.println(" [" + C + "5" + R + "] -> " + C + "🛒" + R + " Afficher le panier");
		System.out.println(" [" + C + "6" + R + "] -> " + C + "📦" + R + " Passer commande");
		if(selectedCustomer != null ) {
			System.out.println(" [" + C + "7" + R + "] -> " + C + "🔒" + R + " Déconnexion");
		} else {
			System.out.println(" [" + C + "8" + R + "] -> " + C + "🔒" + R + " Connexion");
		}
		System.out.println(" [" + C + "9" + R + "] -> " + C + "⛔" + R + " Sortir");
		System.out.println(C + " ▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬" + R);
		System.out.print("\n Saisir le menu [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		choiceMenu(scan.nextInt());
	}
	
	/**
	 * Display user name if user exist
	 * @return
	 */
	public static String displayUser() {
		if(selectedCustomer != null) {
			return " ⌦ Bienvenue, " + selectedCustomer.getLastname() + " " + selectedCustomer.getName();
		}
		return "";
	}
	
	/**
	 * Display types of books
	 */
	public static void displayTypesOfBook() {
		System.out.println("\n [" + C + "1" + R + "] -> " + C + "📕" + R + " Afficher tous les livres");
		System.out.println(" [" + C + "2" + R + "] -> " + C + "📕" + R + " Afficher tous les livres neufs");
		System.out.println(" [" + C + "3" + R + "] -> " + C + "📕" + R + " Afficher tous les livres d'occasion");
		System.out.print("\n Saisir le menu [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		choiceTypesOfBook(scan.nextInt());
	}
	
	/**
	 *  Redirects the user according to his choice
	 * @param choice
	 */
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
	 * Add a book to the shopping cart
	 */
	public static void addBookToCart() {
		Utils.formatDataBook(shop.getAllBooks());
		System.out.print(" Saisir le livre pour l'ajouter au panier [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		if(shop.addBookTocart(shop.getBookById(scan.nextInt()))) {
			System.out.println("\n Le livre à bien été ajouter au panier\n");
		}
	}
	
	/**
	 * Remove a book to the shopping cart
	 */
	public static void removeBookToCart() {
		Utils.formatDataCart(shop.getCart());
		System.out.print(" Saisir le livre pour le supprimer du panier [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		if(shop.removeBookToCart(scan.nextInt())) {
			System.out.println("\n Le livre à bien été supprimer du panier\n");
		}
	}
	
	/**
	 * User authentication
	 */
	public static void auth() {
		System.out.print(C + "\n 👨‍🚀" + R + " Email : ");
		String email = scan.next();
		System.out.print(C + " 🔒" + R + " Password : ");
		String password = scan.next();
		if(shop.authentification(email, password) != null) {
			selectedCustomer = shop.authentification(email, password);
			System.out.println();
		} else {
			System.out.println(C + "\n ⛔" + R + " Utilisateur inconnu\n");
			System.out.print(" Voulez-vous créer un compte [" + C + "O" + R + "/" + C + "N" + R + "] ? : ");
			if(scan.next().equalsIgnoreCase("o")) {
				createUser();
			}
		}
	}
	
	/**
	 * User creation
	 */
	public static void createUser() {
		Customer customer = new Customer();
		System.out.print(C + "\n 👨‍🚀" + R + " Saisir le prénom : ");
		customer.setName(scan.next());
		System.out.print(C + " 👨‍🚀" + R + " Saisir le nom de famille : ");
		customer.setLastname(scan.next());
		System.out.print(C + " 👨‍🚀" + R + " Saisir l'adresse email : ");
		customer.setEmail(scan.next());
		System.out.print(C + " 👨‍🚀" + R + " Saisir le mot de passe : ");
		customer.setPassword(scan.next());
		System.out.print(C + " 👨‍🚀" + R + " Saisir le téléphone : ");
		customer.setPhone(scan.next());
		System.out.print(C + " 👨‍🚀" + R + " Saisir l'adresse postale : ");
		customer.setAddress(scan.next());
		
		if(shop.createCustomer(customer)) {
			System.out.println("\n" + C + " 👨‍🚀‍" + R + " Utilisateur créer avec succès !\n");
		}
	}
	
	/**
	 * Display of themes and possibility to add a book
	 */
	public static void displayTheme() {
		Utils.formatDataTheme(shop.getAllThemes());
		System.out.print(" Saisir le theme choisi [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		Utils.formatDataBook(shop.getAllBooksByTheme(scan.nextInt()));
		System.out.print(" Saisir le livre pour l'ajouter au panier [" + C + "ID" + R + "] : ");
		while(!scan.hasNextInt()) scan.next();
		if(shop.addBookTocart(shop.getBookById(scan.nextInt()))) {
			System.out.println("\n Le livre à bien été ajouter au panier\n");
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
			displayTheme();
			break;
		case 3:
			addBookToCart();
			break;
		case 4:
			removeBookToCart();
			break;
		case 5:
			Utils.formatDataCart(shop.getCart());
			break;
		case 6:
			if(selectedCustomer != null) {
				Utils.formatDataCart(shop.getCart());
				System.out.print(" Voulez-vous valider votre commande [" + C + "O" + R + "/" + C + "N" + R + "] ? : ");
				if(scan.next().equalsIgnoreCase("o")) {
					shop.createOrder(selectedCustomer.getId());
					System.out.println();
				}
			} else {
				auth();
			}
			break;
		case 7:
			selectedCustomer = null;
			System.out.println("\n Déconnexion réussie !\n");
			break;
		case 8:
			auth();
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
