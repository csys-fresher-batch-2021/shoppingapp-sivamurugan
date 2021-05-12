package in.siva.model;

public class ProductDetail {

	// Declaring types of details for a product
	private String name;
	private int price;
	private int quantity;
	private String category;
	
	private ProductDetail() {
		
	}
	// Get values of product details using constructor
	public ProductDetail(String name, int price, int quantity, String category){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	/**
	 * This method is used to get product name
	 * @return
	 */
	public String getProductName() {
		return name;
	}
	
	/**
	 * This method is used to get product price
	 * @return
	 */
	public int getProductPrice() {
		return price;
	}
	
	/**
	 * This method is used to get product quantity
	 * @return
	 */
	public int getProductQuantity() {
		return quantity;
	}
	
	/**
	 * This method is used to get product category
	 * @return
	 */
	public String getProductcategory() {
		return category;
	}
	
	
	
	/**
	 * This method is used to display product details 
	 */
	@Override
	public String toString() {
		return "ProductDetail [productName=" + name + ", productPrice=" + price + ", productQuantity="
				+ quantity + ", productCatagory=" + category + "]";
	}

	
}
