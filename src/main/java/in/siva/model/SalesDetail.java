package in.siva.model;

import java.sql.Timestamp;

public class SalesDetail {
	
	private String username;
	private String vegName;
	private double vegPrice;
	private double eachPrice;
	private int quantity;
	private Timestamp dateTime;
	
	/**
	 * To get username of user
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * To set username of user
	 * @param usernmae
	 */
	public void setUsername(String usernmae) {
		this.username = usernmae;
	}
	
	/**
	 * To get bill amount of a vegetable
	 * @return
	 */
	public double getEachPrice() {
		return eachPrice;
	}
	
	/**
	 * To set bill for a vegetable
	 * @param eachPrice
	 */
	public void setEachPrice(double eachPrice) {
		this.eachPrice = eachPrice;
	}
	
	/**
	 * To get quantity of a vegetable
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * To set a quantity of a vegetable
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * To get date and time of purchase
	 * @return
	 */
	public Timestamp getDateTime() {
		return dateTime;
	}
	
	/**
	 * To set date and time of purchase
	 * @param date
	 */
	public void setDateTime(Timestamp date) {
		this.dateTime = date;
	}
	
	/**
	 * To get vegetable name
	 * @return
	 */
	public String getVegName() {
		return vegName;
	}
	
	/**
	 * To set vegetable name
	 * @param vegName
	 */
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}
	
	/**
	 * To get vegetable price
	 * @return
	 */
	public double getVegPrice() {
		return vegPrice;
	}
	
	/**
	 * To set vegetable price
	 * @param vegPrice
	 */
	public void setVegPrice(double vegPrice) {
		this.vegPrice = vegPrice;
	}
	
	@Override
	public String toString() {
		return "SalesDetail [username=" + username + ", vegName=" + vegName + ", vegPrice=" + vegPrice + ", eachPrice="
				+ eachPrice + ", quantity=" + quantity + ", dateTime=" + dateTime + "]";
	}
	
}


