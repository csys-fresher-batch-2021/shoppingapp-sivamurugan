package in.siva.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.siva.exception.DBException;
import in.siva.exception.ProductInvalidException;
import in.siva.model.ProductDetail;

public class AddProductTest {

	/**
	 * This test case has valid product details and hence it will add product
	 * details
	 */
	@Test
	public void validProductTest1() {

		// Creating object for product 1

		ProductDetail product1 = new ProductDetail("Tomato", 40, 500, "V");

		try {
			ProductService.addProduct(product1);

		} catch (ProductInvalidException e) {
			fail();
		} catch (DBException e) {
			fail();
		}

	}

	/**
	 * This test case has valid product details and hence it will add product
	 * details
	 */
	@Test
	public void validProductTest2() {

		// Creating object for product 2
		ProductDetail product2 = new ProductDetail("Potato", 60, 500, "V");

		try {
			ProductService.addProduct(product2);

		} catch (ProductInvalidException e) {
			fail();
		} catch (DBException e) {
			fail();
			e.printStackTrace();
		}

	}

	/**
	 * This test case has invalid product details and hence it will not add product
	 * details
	 */
	@Test
	public void invalidProductTest1() {

		// Creating object for product 3
		ProductDetail product3 = new ProductDetail(" ", 24, 500, "V");

		try {
			ProductService.addProduct(product3);
			fail();
		} catch (ProductInvalidException e) {
			assertEquals("Invalid Product Details", e.getMessage());
		} catch (DBException e) {
			fail();
		}

	}

	/**
	 * This test case has invalid product details and hence it will not add product
	 * details
	 */
	@Test
	public void invalidProductTest2() {

		// Creating object for product 4
		ProductDetail product4 = new ProductDetail("potato", -4, 430, "V");

		try {
			ProductService.addProduct(product4);
			fail();
		} catch (ProductInvalidException e) {
			assertEquals("Invalid Product Details", e.getMessage());
		} catch (DBException e) {
			fail();
			e.printStackTrace();
		}

	}

	/**
	 * This test case's product name is already present in db so it will return product 
	 * already exists
	 */
	@Test
	public void addingRepeatedProduct() {

		// Creating object for product 4
		ProductDetail product5 = new ProductDetail("potato", 76, 430, "V");

		try {
			ProductService.addProduct(product5);
			fail();
		} catch (ProductInvalidException e) {
			assertEquals("Product Already Exists", e.getMessage());
		} catch (DBException e) {
			fail();
			e.printStackTrace();
		}

	}

}
