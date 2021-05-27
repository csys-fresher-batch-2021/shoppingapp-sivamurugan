package in.siva.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import in.siva.exception.DBException;
import in.siva.exception.EmptyBillException;
import in.siva.exception.InvalidQuantityException;
import in.siva.model.BillDetail;

public class CustomerPurchaseTest {
	
	/**
	 * This test case has proper vegetable detail and quantity So bill amount is calculated and 
	 * result has been validated
	 * @throws DBException
	 */
	@Test
	public void totalBillTest1() throws DBException {
		String[] selectedVegs = {"onion","tomato"}; // Not available in shop
		String[] quantities = {"2", "5"};
		
		List<BillDetail> billDetails;
		try {
			billDetails = SalesService.getBill(selectedVegs, quantities);
			Double totalBill = SalesService.getTotalBill(billDetails);
			assertEquals(320.0, totalBill,0.0);
		} catch (DBException | EmptyBillException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * In this test case bill amount is calculated for different vegetables and 
	 * result validated
	 * @throws DBException
	 */
	@Test
	public void totalBillTest2() throws DBException {
		String[] selectedVegs = {"beans","tomato"}; // Not available in shop
		String[] quantities = {"5", "5"};
		
		List<BillDetail> billDetails;
		try {
			billDetails = SalesService.getBill(selectedVegs, quantities);
			Double totalBill = SalesService.getTotalBill(billDetails);
			assertEquals(400.0, totalBill,0.0);
		} catch (DBException | EmptyBillException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * In this test case quantities are entered as zero so exception occured and exception message validated
	 * @throws DBException
	 */
	@Test
	public void withoutQuantityTest() throws DBException {
		String[] selectedVegs = {"beans","tomato"}; // Not available in shop
		String[] quantities = {"0", "0"};
		
		List<BillDetail> billDetails;
		try {
			billDetails = SalesService.getBill(selectedVegs, quantities);
			Double totalBill = SalesService.getTotalBill(billDetails);
			fail();
		} catch (DBException | InvalidQuantityException | EmptyBillException | NullPointerException e) {
			assertEquals("You didn't entered any Quantities. Please enter quantity", e.getMessage());
		}
		
	}
	
	/**
	 * In this test case negative value for quantity is given so exception message validated
	 * @throws DBException
	 */
	@Test
	public void withNegativeQuality() throws DBException {
		String[] selectedVegs = {"beans","tomato"}; // Not available in shop
		String[] quantities = {"10", "-8"};
		
		List<BillDetail> billDetails;
		try {
			billDetails = SalesService.getBill(selectedVegs, quantities);
			Double totalBill = SalesService.getTotalBill(billDetails);
			fail();
		} catch (DBException | EmptyBillException | InvalidQuantityException | NullPointerException e) {
			assertEquals("You entered Invalid Quantity", e.getMessage());
		}
		
	}
	
	/**
	 * In this test case only one vegetable selected but 2 quantities entered by user
	 * So in this case selected product price is calculated and validated
	 * @throws DBException
	 */
	@Test
	public void sizeDiffBwQuantityAndVeg() throws DBException {
		String[] selectedVegs = {"beans"}; // Not available in shop
		String[] quantities = {"10", "8"};
		
		List<BillDetail> billDetails;
		try {
			billDetails = SalesService.getBill(selectedVegs, quantities);
			Double totalBill = SalesService.getTotalBill(billDetails);
			assertEquals(400.0, totalBill, 0.0);
		} catch (DBException | EmptyBillException | InvalidQuantityException | NullPointerException e) {
			fail();
		}
		
	}

	/**
	 * In this test case no product is selected and quantity entered so exception message validated
	 * @throws DBException
	 */
	@Test
	public void withoutDetailsTest() throws DBException {
		String[] selectedVegs = {}; // Not available in shop
		String[] quantities = {};
		
		List<BillDetail> billDetails;
		try {
			billDetails = SalesService.getBill(selectedVegs, quantities);
			Double totalBill = SalesService.getTotalBill(billDetails);
			fail();
		} catch (DBException | EmptyBillException | InvalidQuantityException | NullPointerException e) {
			assertEquals("You didn't entered any Quantities. Please enter quantity", e.getMessage());
		}
		
	}
	
	/**
	 * In this test case no vegetables no vegetables selected but quantity entered so exception message validated 
	 * @throws DBException
	 */
	@Test
	public void withQuantityWithoutVegTest() throws DBException {
		String[] selectedVegs = {}; // Not available in shop
		String[] quantities = {"2","4"};
		
		List<BillDetail> billDetails;
		try {
			billDetails = SalesService.getBill(selectedVegs, quantities);
			Double totalBill = SalesService.getTotalBill(billDetails);
			fail();
		} catch (DBException | EmptyBillException | InvalidQuantityException | NullPointerException e) {
			assertEquals("You didn't entered any Quantities. Please enter quantity", e.getMessage());
		}
		
	}
	
}
