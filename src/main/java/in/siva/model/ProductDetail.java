package in.siva.model;

public class ProductDetail {

	// Declaring types of details for a product
	private String productName;
	private int productPrice;
	private int productQuantity;
	private String productCategory;
	
	
	// Get values of product details using constructor
	public ProductDetail(String productName, int productPrice, int productQuantity, String productCategory){
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productCategory = productCategory;
	}
	
	/**
	 * This method is used to get product name
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * This method is used to get product price
	 * @return
	 */
	public int getProductPrice() {
		return productPrice;
	}
	
	/**
	 * This method is used to get product quantity
	 * @return
	 */
	public int getProductQuantity() {
		return productQuantity;
	}
	
	/**
	 * This method is used to get product category
	 * @return
	 */
	public String getProductcategory() {
		return productCategory;
	}
	
	
	
	/**
	 * This method is used to display product details 
	 */
	@Override
	public String toString() {
		return "ProductDetail [productName=" + productName + ", productPrice=" + productPrice + ", productQuantity="
				+ productQuantity + ", productCatagory=" + productCategory + "]";
	}

	
}
