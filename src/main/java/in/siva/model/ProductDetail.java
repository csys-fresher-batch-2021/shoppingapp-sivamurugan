package in.siva.model;

public class ProductDetail {

	// Declaring types of details for a product
	public String productName;
	public float productPrice;
	public int productQuantity;
	public String productCatagory;
	
	// Get values of product details using constructor
	public ProductDetail(String productName, float productPrice, int productQuantity, String productCatagory){
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productCatagory = productCatagory;
	}
	
	/**
	 * This method is used to display product details 
	 */
	@Override
	public String toString() {
		return "ProductDetail [productName=" + productName + ", productPrice=" + productPrice + ", productQuantity="
				+ productQuantity + ", productCatagory=" + productCatagory + "]";
	}

	
}
