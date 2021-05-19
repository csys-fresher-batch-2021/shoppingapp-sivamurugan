package in.siva.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.siva.exception.DBException;
import in.siva.exception.ProductInvalidException;

public class RemoveProductTest {

	/**
	 * In this test case valid product name is given so product removed
	 */
	@Test
	public void validProductRemoveTest() {
		try {
			try {
				ProductService.removeProduct("Apple");
			} catch (DBException e) {
				fail();
			}
		} catch (ProductInvalidException e) {
			fail();
		}
	}

	/**
	 * In this test case invalid product name is given so Invalid product name
	 * message
	 */
	@Test
	public void invalidProductRemoveTest() {
		try {
				ProductService.removeProduct("Grapes");
	
		} catch (ProductInvalidException e) {
			assertEquals("Invalid Product Name", e.getMessage());
		} catch (DBException e) {
			fail();
		}
	}
}
