package in.siva.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.siva.exception.DBException;
import in.siva.exception.VegInvalidException;

public class RemoveVegTest {

	/**
	 * In this test case valid product name is given so product removed
	 */
	@Test
	public void validRemoveVegTest() {
		try {
			try {
				VegetableService.removeVeg("Apple");
			} catch (DBException e) {
				fail();
			}
		} catch (VegInvalidException e) {
			fail();
		}
	}

	/**
	 * In this test case invalid product name is given so Invalid product name
	 * message
	 */
	@Test
	public void invalidVegRemoveTest() {
		try {
				VegetableService.removeVeg("Grapes");
	
		} catch (VegInvalidException e) {
			assertEquals("Invalid Product Name", e.getMessage());
		} catch (DBException e) {
			fail();
		}
	}
}
