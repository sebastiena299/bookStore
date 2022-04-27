package fr.fms.entities;

public class OrderDetail {
	
	private int id;
	private int idOrder;
	private int idBook;
	private int quantity;
	private float price;
	
	public OrderDetail() {};
	
	public OrderDetail(int idOrder, int idBook, float price, int quantity) {
		setIdOrder(idOrder);
		setIdBook(idBook);
		setQuantity(quantity);
		setPrice(price);
	}
	
	public OrderDetail(int id, int idOrder, int idBook, float price, int quantity) {
		setId(id);
		setIdOrder(idOrder);
		setIdBook(idBook);
		setQuantity(quantity);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdOrder() {
		return idOrder;
	}
	
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	
	public int getIdBook() {
		return idBook;
	}
	
	public void setIdBook(int idBook) {
		this.idBook = idBook;
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
	
	@Override
	public String toString() {
		return "[ Id Book : " + getIdBook() + " | Qty : " + getQuantity() + " | Prix : " + getPrice() + " ]";
	}
	
}
