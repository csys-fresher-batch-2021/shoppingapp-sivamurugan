package in.siva.service;

import java.util.ArrayList;
import java.util.List;

import in.siva.exception.ProductInvalidException;
import in.siva.model.ProductDetail;
import in.siva.validator.ProductValidator;


public class ProductService {
		// Global ArrayList Declaration to store product details
		private final static List<ProductDetail> productDetails = new ArrayList<>();

		
		private ProductService() {
			// Default constructor
		}
		
		/**
		 * This method is used to check whether the product is repeated or not
		 * @param productName
		 */
		
		public static boolean isProductNotRepeated(String productName) {
			boolean valid = true;
			for (ProductDetail product : productDetails) {
				if(product.getProductName().equalsIgnoreCase(productName)) {
					valid = false;
					break;
				}
			}
			return valid;
		}
		
		
		
		/**
		 * This method is used to add a product 
		 * If name, price, quantity and catagory is valid then it will add product 
		 * Otherwise it will raise a RuntimeException of "Invalid Product Details"
		 * @param product
		 */
		public static void addProduct(ProductDetail product) {
			
			// Business Logic
			if (ProductValidator.isStringValid(product.getProductName())
					&& ProductValidator.isNumberValid(product.getProductPrice())
					&& ProductValidator.isNumberValid(product.getProductQuantity())
					&& ProductValidator.isStringValid(product.getProductCategory())) {
				if(isProductNotRepeated(product.getProductName())) {
					productDetails.add(product);
				}
				else {
					throw new ProductInvalidException("Product Already Exists");
				}
				
			} else {
				throw new ProductInvalidException("Invalid Product Details");
			}
		}
		
		/**
		 * This method is used to return product details
		 * @return
		 */
		public static List<ProductDetail> getProducts() {
			return productDetails;
		}
		
		

}
