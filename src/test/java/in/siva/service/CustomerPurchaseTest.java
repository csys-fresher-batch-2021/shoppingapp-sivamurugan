package in.siva.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import in.siva.exception.DBException;
import in.siva.model.BillDetail;

public class CustomerPurchaseTest {

	@Test
	public void customerPurchaseTest1() {
		List<BillDetail> billDetails = new ArrayList<>();
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
		
		try {
			SalesService.storeSalesDetails("Karan", billDetails);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

}
