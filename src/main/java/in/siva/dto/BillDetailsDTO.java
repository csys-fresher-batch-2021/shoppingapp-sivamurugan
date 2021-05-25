package in.siva.dto;

import java.util.ArrayList;
import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.exception.DBException;
import in.siva.exception.VegInvalidException;
import in.siva.model.BillDetail;

public class BillDetailsDTO {
	private BillDetailsDTO() {
		// To avoid object creation in other class
	}

	public static List<BillDetail> getBillForEachVeg(String[] selectedVeg, String[] quantities,
			List<Double> eachVegBill) throws DBException {
		final List<BillDetail> billDetails = new ArrayList<>();
		for (int i = 0; i < selectedVeg.length; i++) {
			String vegName = selectedVeg[i];
			int vegQuantity = Integer.parseInt(quantities[i]);
			if (vegQuantity != 0) {
				int price = VegDetailDao.findPriceByName(vegName);
				double bill = eachVegBill.get(i);
				BillDetail vegetable = new BillDetail();
				vegetable.setVegName(vegName);
				vegetable.setPrice(price);
				vegetable.setQuantity(vegQuantity);
				vegetable.setEachVegBill(bill);
				billDetails.add(vegetable);
			} else {
				throw new NullPointerException();
			}
		}
		return billDetails;
	}
}