package in.siva.model;

import java.sql.Timestamp;

public class SalesDetail {
	private String username;
	private String vegName;
	private double vegPrice;
	private double eachPrice;
	private int quantity;
	private Timestamp dateTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String usernmae) {
		this.username = usernmae;
	}
	public double getEachPrice() {
		return eachPrice;
	}
	public void setEachPrice(double eachPrice) {
		this.eachPrice = eachPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp date) {
		this.dateTime = date;
	}
	
	public String getVegName() {
		return vegName;
	}
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}
	
	public double getVegPrice() {
		return vegPrice;
	}
	public void setVegPrice(double vegPrice) {
		this.vegPrice = vegPrice;
	}
	
}


