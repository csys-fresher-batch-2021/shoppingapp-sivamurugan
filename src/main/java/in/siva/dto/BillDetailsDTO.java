package in.siva.dto;

import java.util.ArrayList;
import java.util.List;

import in.siva.dao.VegDetailDAO;
import in.siva.exception.DBException;
import in.siva.model.BillDetail;

public class BillDetailsDTO {
	private BillDetailsDTO() {
		// To avoid object creation in other class
	}

	/**
	 * This method is used to get bill amount for vegetables
	 * It will all details of bill in a BillDetail Object and add them in a list
	 * And finally it will return the list of billDetails
	 * @param selectedVeg
	 * @param quantities
	 * @param eachVegBill
	 * @return
	 * @throws DBException
	 */
	public static List<BillDetail> getBillForVeg(String[] selectedVeg, String[] quantities,
			List<Double> eachVegBill) throws DBException {
		// List to add billDetails
		final List<BillDetail> billDetails = new ArrayList<>();		
		// Business Logic
		for (int i = 0; i < selectedVeg.length; i++) {
			String vegName = selectedVeg[i];
			int vegQuantity = Integer.parseInt(quantities[i]);
			if (vegQuantity != 0) {
				int price = VegDetailDAO.findPriceByName(vegName);
				double bill = eachVegBill.get(i);
				BillDetail vegetable = new BillDetail();
				vegetable.setVegName(vegName);
				vegetable.setPrice(price);
				vegetable.setQuantity(vegQuantity);
				vegetable.setEachVegBill(bill);
				billDetails.add(vegetable);
			}
		}
		return billDetails;
	}
}
