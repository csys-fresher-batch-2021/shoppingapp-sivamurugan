package in.siva.logics;

import java.util.ArrayList;
import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.exception.DBException;
import in.siva.exception.InvalidSelectionException;
import in.siva.model.BillDetail;
import in.siva.model.VegDetail;
import in.siva.model.SelectedVegetables;
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
	public static void main(String[] args) throws DBException {
		String[] s = {"tomato", "potato", "ukhudf"};
		String[] a = {"30","20","10"};
		System.out.println(billForEachVegetable(s, a));
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
