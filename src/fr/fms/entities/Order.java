package fr.fms.entities;

import java.sql.Date;

public class Order {
	
	private int id;
	private float totalAmount;
	private Date createdAt;
	private int idUser;
	
	public Order() {};
	
	public Order(float totalAmount, int idUser) {
		setTotalAmount(totalAmount);
		setIdUser(idUser);
	}
	
	public Order(int id, float totalAmount, int idUser) {
		setId(id);
		setTotalAmount(totalAmount);
		setIdUser(idUser);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public String toString() {
		return "[ Id : " + getId() + " | Total : " + getTotalAmount() + " | Date : " + getCreatedAt() + " ]";
	}
	
}
