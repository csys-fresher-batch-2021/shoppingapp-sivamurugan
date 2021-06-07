package in.siva.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.siva.exception.DBException;
import in.siva.exception.VegInvalidException;
import in.siva.model.VegDetail;

public class AddVegetableTest {

	/**
	 * This test case has valid product details and hence it will add product
	 * details
	 */
	@Test
	public void validVegTest1() {
		// Creating object for product 1
		VegDetail veg1 = new VegDetail("Tomato", 40, 500);
		try {
			VegetableService.addVeg(veg1);

		} catch (VegInvalidException e) {
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
	public void validVegTest2() {
		// Creating object for product 2
		VegDetail veg2 = new VegDetail("Potato", 60, 500);
		try {
			VegetableService.addVeg(veg2);
		} catch (VegInvalidException e) {
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
	public void invalidVegTest1() {
		// Creating object for product 3
		VegDetail veg = new VegDetail(" ", 24, 500);
		try {
			VegetableService.addVeg(veg);
			fail();
		} catch (VegInvalidException e) {
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
	public void invalidVegTest2() {
		// Creating object for product 4
		VegDetail veg = new VegDetail("potato", -4, 430);
		try {
			VegetableService.addVeg(veg);
			fail();
		} catch (VegInvalidException e) {
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
	public void addingRepeatedVeg() {
		// Creating object for product 4
		VegDetail veg = new VegDetail("potato", 76, 430);
		try {
			VegetableService.addVeg(veg);
			fail();
		} catch (VegInvalidException e) {
			assertEquals("Product Already Exists", e.getMessage());
		} catch (DBException e) {
			fail();
			e.printStackTrace();
		}
	}
}
