package in.siva.logics;

import java.util.ArrayList;
import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.exception.DBException;
import in.siva.exception.InvalidQuantityException;
import in.siva.model.BillDetail;
import in.siva.validator.VegetableValidator;

public class BillCalculator {
	private BillCalculator() {
		// To avoid object creation
	}

	/**
	 * This method is used to calculate bill for each product and add it in a list
	 * Then it will return the list
	 * 
	 * @param selectedVegs
	 * @param quantities
	 * @return
	 * @throws DBException
	 */
	public static List<Double> billForEachVegetable(String[] selectedVegs, String[] quantities) throws DBException {
		List<Double> eachVegBill = new ArrayList<>();

		// Business logic
		for (int i = 0; i < selectedVegs.length; i++) {
			Double bill;
			String vegName = selectedVegs[i];
			int vegQuantity = Integer.parseInt(quantities[i]);
			if (vegQuantity < 0) {
				throw new InvalidQuantityException("You entered Invalid Quantity");
				
			} else {
				if (VegetableValidator.isVegMatches(vegName)) {
					int price = VegDetailDao.findPriceByName(vegName);
					bill = (double) vegQuantity * (double) price;
					eachVegBill.add(bill);
				}
			}

		}
		return eachVegBill;
	}

	/**
	 * This method is used to calculate total bill of a customer
	 * 
	 * @param billDetails
	 * @return
	 */
	public static double getTotalBill(List<BillDetail> billDetails) {
		double totalBill = 0;
		for (BillDetail veg : billDetails) {
			double price = veg.getEachVegBill();
			totalBill = totalBill + price;
		}
		return totalBill;
	}
}
