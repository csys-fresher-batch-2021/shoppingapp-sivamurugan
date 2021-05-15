package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.exception.ProductInvalidException;
import in.siva.model.ProductDetail;

public class RemoveProductTest {

	/**
	 * Static block is used to add some products initially 
	 */
	static {
		ProductDetail product1= new ProductDetail("Apple", 80, 200, "fruits");
		ProductDetail product2= new ProductDetail("Orange", 80, 200, "fruits");
		ProductDetail product3= new ProductDetail("Banana", 80, 200, "fruits");
		ProductDetail product4= new ProductDetail("Guava", 80, 200, "fruits");
		
		ProductService.addProduct(product1);
		ProductService.addProduct(product2);
		ProductService.addProduct(product3);
		ProductService.addProduct(product4);
	}
	
	/**
	 * In this test case valid product name is given so product removed 
	 */
	@Test
	public void validProductRemoveTest() {
		try {
			ProductService.removeProduct("Apple");
		} catch(ProductInvalidException e){
			fail();
		}
	}
	
	/**
	 * In this test case invalid product name is given so Invalid product name message
	 */
	@Test
	public void invalidProductRemoveTest() {
		try {
			ProductService.removeProduct("Grapes");
		} catch(ProductInvalidException e){
			assertEquals("Invalid Product Name", e.getMessage());
		}
	}

}
