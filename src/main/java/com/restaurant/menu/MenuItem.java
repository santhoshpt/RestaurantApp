package com.restaurant.menu;

public class MenuItem {
	private String id;
	private String name;
	private String description;
	private String price;
	
	public MenuItem(String id, String name, String description, String price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"id: \"").append("\""+id+"\",");
		sb.append("\"name: \"").append("\""+name+"\",");
		sb.append("\"description: \"").append("\""+description+"\",");
		sb.append("\"price: \"").append("\""+price+"\"");
		sb.append("}");
		return sb.toString();
	}
}