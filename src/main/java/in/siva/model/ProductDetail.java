package in.siva.model;

public class ProductDetail {

	// Declaring types of details for a product
	private String name;
	private int price;
	private int quantity;
	private String category;
	
	public ProductDetail() {
		// Default constructor
	}
	
	// Get values of product details using constructor
	public ProductDetail(String name, int price, int quantity, String category){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	/**
	 * This method is used to set name for product
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method is used to set price for product
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * This method is used to set stock quantity amount of product
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * This method is used to set category of the product
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * This method is used to get product name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method is used to get product price
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * This method is used to get product quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * This method is used to get product category
	 * @return
	 */
	public String getCategory() {
		return category;
	}
	
	
}
