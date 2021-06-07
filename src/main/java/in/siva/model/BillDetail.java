package in.siva.model;

import java.io.Serializable;

public class BillDetail implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vegName;
	private int price;
	private int quantity;
	private double eachVegBill;	
	/**
	 * To get vegetable name 
	 * @return
	 */
	public String getVegName() {
		return vegName;
	}
	/**
	 * To set Vegetable name
	 * @param vegName
	 */
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}	
	/**
	 * To get price of vegetable
	 * @return
	 */
	public int getPrice() {
		return price;
	}	
	/**
	 * To set price of vegetable
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}	
	/**
	 * To get vegetable quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}	
	/**
	 * To set vegetable quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * To get bill amount for each vegetable
	 * @return
	 */
	public double getEachVegBill() {
		return eachVegBill;
	}	
	/**
	 * To set bill amount for each vegetable
	 * @param eachVegBill
	 */
	public void setEachVegBill(double eachVegBill) {
		this.eachVegBill = eachVegBill;
	}	
	@Override
	public String toString() {
		return "BillDetail [vegName=" + vegName + ", price=" + price + ", quantity=" + quantity + ", eachVegBill="
				+ eachVegBill + "]";
	}
}
