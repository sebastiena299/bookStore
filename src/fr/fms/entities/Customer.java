package fr.fms.entities;

public class Customer {
	
	private int id;
	private String name;
	private String lastname;
	private String email;
	private String password;
	private String phone;
	private String address;
	private int roles;
	
	public Customer() {};
	
	public Customer(String name, String lastname, String email, String password, String phone, String address) {
		setName(name);
		setLastname(lastname);
		setEmail(email);
		setPassword(password);
		setPhone(phone);
		setAddress(address);
	}
	
	public Customer(int id, String name, String lastname, String email, String password, String phone, String address) {
		setId(id);
		setName(name);
		setLastname(lastname);
		setEmail(email);
		setPassword(password);
		setPhone(phone);
		setAddress(address);
	}
	
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
		return "[ Prénom : " + getName() + " | Nom : " + getLastname() + " | Email : " + getEmail() + " ]";
	}

}
