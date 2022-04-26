package fr.fms.entities;

public class Book {
	
	private int id;
	private String title;
	private String description;
	private String author;
	private int quantity;
	private float price;
	private boolean usedBook;
	
	public Book() {};
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean isUsedBook() {
		return usedBook;
	}
	
	public void setUsedBook(boolean usedBook) {
		this.usedBook = usedBook;
	}
	
	@Override
	public String toString() {
		return "[ Titre : " + getTitle() + " | Autheur : " + getAuthor() + " | Prix : " + getPrice() + " ]";
	}
	
}
