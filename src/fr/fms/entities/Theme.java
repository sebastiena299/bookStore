package fr.fms.entities;

public class Theme {
	
	private int id;
	private String name;
	
	public Theme() {};
	
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
	
	@Override
	public String toString() {
		return "[ Id : " + getId() + " | Nom : " + getName() + " ]";
	}
	
}
