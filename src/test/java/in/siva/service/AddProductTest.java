package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.exception.ProductInvalidException;
import in.siva.model.ProductDetail;

public class AddProductTest {

	/**
	 * This test case has valid product details and hence it will add product details
	 */
	@Test
	public void validProductTest1() {

		// Creating object for product 1 
		 
		ProductDetail product1 = new ProductDetail("Tomato", 24, 500, "Vegetables");
		
		try {
			ProductServiceManagement.addProduct(product1);
			
		}
		catch(ProductInvalidException e) {
			fail();
		}

		
	}
	
	/**
	 * This test case has valid product details and hence it will add product details
	 */
	@Test
	public void validProductTest2() {

		// Creating object for product 2 
		ProductDetail product2 = new ProductDetail("Potato", 24, 500, "Vegetables");
		
		try {
			ProductServiceManagement.addProduct(product2);
			
		}
		catch(ProductInvalidException e) {
			fail();
		}

		
	}
	
	
	/**
	 * This test case has invalid product details and hence it will not add product details
	 */
	@Test
	public void invalidProductTest1() {

		// Creating object for product 3 
		ProductDetail product3 = new ProductDetail(" ", 24, 500, "Vegetables");
		
		try {
			ProductServiceManagement.addProduct(product3);
			fail();
		}
		catch(ProductInvalidException e) {
			assertEquals("Invalid Product Details", e.getMessage());
		}

		
	}
	
	
	/**
	 * This test case has invalid product details and hence it will not add product details
	 */
	@Test
	public void invalidProductTest2() {

		// Creating object for product 4 
		ProductDetail product4 = new ProductDetail("potato", -4, 430, "vegetables");

		try {
			ProductServiceManagement.addProduct(product4);
			fail();
		}
		catch(ProductInvalidException e) {
			assertEquals("Invalid Product Details", e.getMessage());
		}

		
	}
	
	
	@Test
	public void addingRepeatedProduct() {

		// Creating object for product 4 
		ProductDetail product5 = new ProductDetail("potato", 76, 430, "vegetables");

		try {
			ProductServiceManagement.addProduct(product5);
			fail();
		}
		catch(ProductInvalidException e) {
			assertEquals("Product Already Exists", e.getMessage());
		}

		
	}

}
