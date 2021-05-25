package in.siva.service;

import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.dao.SalesDetailsDAO;
import in.siva.dto.BillDetailsDTO;
import in.siva.dto.SalesDetailDTO;
import in.siva.exception.DBException;
import in.siva.logics.BillCalculator;
import in.siva.model.SalesDetail;
import in.siva.model.BillDetail;
import in.siva.util.DateTimeUtil;
import in.siva.validator.BillValidator;

public class SalesService {
	private SalesService() {

	}

	public static List<BillDetail> getBill(String[] selectedVegs, String[] quantities)
			throws Exception {
		List<Double> billForEachVeg = BillCalculator.billForEachVegetable(selectedVegs, quantities);

		List<BillDetail> billDetails = BillDetailsDTO.getBillForEachVeg(selectedVegs, quantities, billForEachVeg);
		BillValidator.isBillValid(billDetails);
		
		return billDetails;

	}

	public static double getTotalBill(List<BillDetail> billDetails) {
		return BillCalculator.getTotalBill(billDetails);
	}

	public static String getDateTime() {
		return DateTimeUtil.getDateTime();
	}
	
	public static int getStockQuantity(SalesDetail saleDetail) throws DBException {
		int stockQuantity = VegDetailDao.findStockByName(saleDetail.getVegName());
		return (stockQuantity - saleDetail.getQuantity());
		
		
	}

	public static void storeSalesDetails(String username, List<BillDetail> billDetails) throws DBException {
		String dateTime = getDateTime();
		for (BillDetail billDetail : billDetails) {
			SalesDetail saleDetail = SalesDetailDTO.setSalesDetail(billDetail, username, dateTime);
			SalesDetailsDAO.save(saleDetail);
			int stockQuantity = getStockQuantity(saleDetail);
			VegDetailDao.updateStock(saleDetail.getVegName(), stockQuantity);
		}

	}
}
