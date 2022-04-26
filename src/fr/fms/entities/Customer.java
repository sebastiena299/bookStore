package fr.fms.entities;

public class Customer {
	
	private int id;
	private String name;
	private String lastname;
	private String email;
	private String phone;
	private String address;
	private int roles;
	
	public Customer() {};
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getRoles() {
		return roles;
	}

	public void setRoles(int roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "[ Pr�nom : " + getName() + " | Nom : " + getLastname() + " | Email : " + getEmail() + " ]";
	}

}
