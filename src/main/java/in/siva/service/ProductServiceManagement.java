package in.siva.service;

import java.util.ArrayList;
import java.util.List;

import in.siva.model.ProductDetail;
import in.siva.validator.ProductValidator;


public class ProductServiceManagement {
		// Global ArrayList Declaration to store product details
		private static List<ProductDetail> productDetails = new ArrayList<ProductDetail>();

		/**
		 * This method is used to add a product 
		 * If name, price, quantity and catagory is valid then it will add product 
		 * Otherwise it will raise a RuntimeException of "Invalid Product Details"
		 * @param product
		 */
		public static void addProduct(ProductDetail product) {
			
			// Business Logic
			if (ProductValidator.isStringValid(product.productName)
					&& isProductNotRepeated(product.productName)
					&& ProductValidator.isPriceValid(product.productPrice)
					&& ProductValidator.isProductQuantityValid(product.productQuantity)
					&& ProductValidator.isStringValid(product.productCatagory)) {
				productDetails.add(product);
			} else {
				throw new RuntimeException("Invalid Product Details");
			}
		}
		
		/**
		 * This method is used to check whether the product is repeated or not
		 * @param productName
		 */
		
		public static boolean isProductNotRepeated(String productName) {
			boolean valid = true;
			for (ProductDetail product : productDetails) {
				if(product.productName.equalsIgnoreCase(productName)) {
					valid = false;
					break;
				}
			}
			return valid;
		}

}
