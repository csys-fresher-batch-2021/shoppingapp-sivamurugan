package in.siva.model;

public class OrderItem {
	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", vegName=" + vegName + ", price=" + price + ", quantity=" + quantity
				+ ", eachVegPrice=" + eachVegPrice + "]";
	}
	private long orderId;
	private String vegName;
	private double price;
	private int quantity;
	private double eachVegPrice;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getVegName() {
		return vegName;
	}
	public void setVegName(String vegName) {
		this.vegName = vegName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getEachVegPrice() {
		return eachVegPrice;
	}
	public void setEachVegPrice(double eachVegPrice) {
		this.eachVegPrice = eachVegPrice;
	}	
}
