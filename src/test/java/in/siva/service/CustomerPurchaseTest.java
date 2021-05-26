package in.siva.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.DoubleSeqHelper;

import in.siva.exception.DBException;
import in.siva.logics.BillCalculator;
import in.siva.model.BillDetail;
import in.siva.validator.BillValidator;

public class CustomerPurchaseTest {

	@Test
	public void validCustomerTotalBillTest() throws DBException {
		final List<BillDetail> billDetails = new ArrayList<>();
		BillDetail billDetail1 = new BillDetail();
		BillDetail billDetail2 = new BillDetail();
		
		billDetail1.setVegName("tomato");
		billDetail1.setPrice(30);
		billDetail1.setQuantity(10);
		billDetail1.setEachVegBill(300);
		
		billDetail2.setVegName("potato");
		billDetail2.setPrice(40);
		billDetail2.setQuantity(10);
		billDetail2.setEachVegBill(400);
		
		billDetails.add(billDetail1);
		billDetails.add(billDetail2);
		
		double bill = SalesService.getTotalBill(billDetails);
		assertEquals(700.0, bill, 0.0);
	}
	
	@Test
	public void invalidCustomerTotalBillTest() throws DBException {
		List<BillDetail> billDetails = new ArrayList<>();
		BillDetail billDetail1 = new BillDetail();
		BillDetail billDetail2 = new BillDetail();
		
		billDetail1.setVegName("tomato");
		billDetail1.setPrice(40);
		billDetail1.setQuantity(10);
		billDetail1.setEachVegBill(400);
		
		billDetail2.setVegName("potato");
		billDetail2.setPrice(90);
		billDetail2.setQuantity(10);
		billDetail2.setEachVegBill(900);
		
		billDetails.add(billDetail1);
		billDetails.add(billDetail2);
		
		double bill = SalesService.getTotalBill(billDetails);
		assertNotEquals(700.0, bill, 0.0);
	}
	
	@Test
	public void validEachVegBillTest() throws DBException {
		String[] selectedVegs = {"tomato", "potato"};
		String[] quantities = {"5","2"};
		List<Double> billForEachVeg = BillCalculator.billForEachVegetable(selectedVegs, quantities);
		String billForVeg = String.valueOf(billForEachVeg);
		assertEquals("[200.0, 110.0]", billForVeg);
	}
	
	@Test
	public void invalidEachVegBillTest() throws DBException {
		String[] selectedVegs = {"onion"}; // Not available in shop
		String[] quantities = {"5"};
		List<Double> billForEachVeg = BillCalculator.billForEachVegetable(selectedVegs, quantities);
		String billForVeg = String.valueOf(billForEachVeg);
		assertEquals("[300.0]", billForVeg);
	}
	
	@Test
	public void invalidBillTest() throws DBException {
		String[] selectedVegs = {"onion", "tomato"}; // Not available in shop
		String[] quantities = {"0", "0"};
		List<Double> billForEachVeg = BillCalculator.billForEachVegetable(selectedVegs, quantities);
		String billForVeg = String.valueOf(billForEachVeg);
		assertEquals("[0.0, 0.0]", billForVeg);
	}

}
