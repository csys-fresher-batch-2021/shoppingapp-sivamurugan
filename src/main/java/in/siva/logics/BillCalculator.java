package in.siva.logics;

import java.util.ArrayList;
import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.exception.DBException;
import in.siva.model.BillDetail;
import in.siva.validator.VegetableValidator;

public class BillCalculator {
	private BillCalculator() {
		// To avoid object creation
	}

	public static List<Double> billForEachVegetable(String[] selectedVegs, String[] quantities) throws DBException {
		List<Double> eachVegBill = new ArrayList<>();

		for (int i=0;i<selectedVegs.length;i++) {
			Double bill;
			String vegName = selectedVegs[i];
			int vegQuantity = Integer.parseInt(quantities[i]);
			if (VegetableValidator.isVegMatches(vegName)) {
				int price = VegDetailDao.findPriceByName(vegName);
				bill = (double)vegQuantity * (double)price;
				eachVegBill.add(bill);
			}
			
		}
		return eachVegBill;
	}
	
	public static double getTotalBill(List<BillDetail> billDetails) {
		double totalBill = 0;
		for (BillDetail veg : billDetails) {
			double price = veg.getEachVegBill();
			totalBill = totalBill + price;
		}
		return totalBill;
	}
}
