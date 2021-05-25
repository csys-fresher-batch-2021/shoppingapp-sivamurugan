package in.siva.model;

public class BillDetail {
	
	private String vegName;
	private int price;
	private int quantity;
	private double eachVegBill;
	
	
	public String getVegName() {
		return vegName;
	}
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getEachVegBill() {
		return eachVegBill;
	}
	public void setEachVegBill(double eachVegBill) {
		this.eachVegBill = eachVegBill;
	}
	
	@Override
	public String toString() {
		return "BillDetail [vegName=" + vegName + ", price=" + price + ", quantity=" + quantity + ", eachVegBill="
				+ eachVegBill + "]";
	}
}
