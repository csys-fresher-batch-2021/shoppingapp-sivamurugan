package in.siva.service;

import java.time.LocalDateTime;
import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.dao.SalesDetailsDAO;
import in.siva.dto.BillDetailsDTO;
import in.siva.dto.SalesDetailDTO;
import in.siva.exception.DBException;
import in.siva.exception.InvalidSelectionException;
import in.siva.logics.BillCalculator;
import in.siva.model.VegDetail;
import in.siva.model.SalesDetail;
import in.siva.model.BillDetail;
import in.siva.util.DateTimeUtil;
import in.siva.validator.VegetableValidator;

public class SalesService {
	private SalesService() {

	}

	public static List<BillDetail> getBill(String[] selectedVegs, String[] quantities)
			throws DBException {
		List<Double> billForEachVeg = BillCalculator.billForEachVegetable(selectedVegs, quantities);

		return BillDetailsDTO.getBillForEachVeg(selectedVegs, quantities, billForEachVeg);

	}

	public static double getTotalBill(List<BillDetail> billDetails) {
		return BillCalculator.getTotalBill(billDetails);
	}

	public static String getDateTime() {
		return DateTimeUtil.getDateTime();
	}
	
	public static int getStockQuantity(SalesDetail saleDetail) throws DBException {
		int stockQuantity = VegDetailDao.findStockByName(saleDetail.getVegName());
		System.out.println(stockQuantity - saleDetail.getQuantity());
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
