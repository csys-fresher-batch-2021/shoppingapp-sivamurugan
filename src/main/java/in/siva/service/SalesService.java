package in.siva.service;

import java.util.List;

import in.siva.dao.VegDetailDao;
import in.siva.dao.SalesDetailsDAO;
import in.siva.dto.BillDetailsDTO;
import in.siva.dto.SalesDetailDTO;
import in.siva.exception.DBException;
import in.siva.exception.EmptyBillException;
import in.siva.logics.BillCalculator;
import in.siva.model.SalesDetail;
import in.siva.model.BillDetail;
import in.siva.util.DateTimeUtil;
import in.siva.validator.BillValidator;

public class SalesService {
	private SalesService() {
		// To avoid object creation in other class
	}

	/**
	 * This method is used to get bill amount for selected vegetables and quantities
	 * @param selectedVegs
	 * @param quantities
	 * @return
	 * @throws EmptyBillException 
	 * @throws DBException 
	 * @throws Exception
	 */
	public static List<BillDetail> getBill(String[] selectedVegs, String[] quantities) throws DBException, EmptyBillException {
		
		//To get bill for each vegetable
		List<Double> billForEachVeg = BillCalculator.billForEachVegetable(selectedVegs, quantities);

		// To get bill details
		List<BillDetail> billDetails = BillDetailsDTO.getBillForVeg(selectedVegs, quantities, billForEachVeg);
		
		// Bill validation
		BillValidator.isBillValid(billDetails);
		
		return billDetails;

	}

	/**
	 * This method is used to get total bill amount of a purchase
	 * @param billDetails
	 * @return
	 */
	public static double getTotalBill(List<BillDetail> billDetails) {
		return BillCalculator.getTotalBill(billDetails);
	}

	/**
	 * This method is used to get date and time of purchase
	 * @return
	 */
	public static String getDateTime() {
		return DateTimeUtil.getDateTime();
	}
	
	/**
	 * This method is used to get new stock quantity after purchase
	 * @param saleDetail
	 * @return
	 * @throws DBException
	 */
	public static int getNewStockQuantity(SalesDetail saleDetail) throws DBException {
		int stockQuantity = VegDetailDao.findStockByName(saleDetail.getVegName());
		return (stockQuantity - saleDetail.getQuantity());
		
		
	}

	/**
	 * This method is used to store salesDetails of a purchase after order confirmed
	 * @param username
	 * @param billDetails
	 * @throws DBException
	 */
	public static void storeSalesDetails(String username, List<BillDetail> billDetails) throws DBException {
		String dateTime = getDateTime();
		for (BillDetail billDetail : billDetails) {
			SalesDetail saleDetail = SalesDetailDTO.setSalesDetail(billDetail, username, dateTime);
			SalesDetailsDAO.saveSalesDetails(saleDetail);
			int stockQuantity = getNewStockQuantity(saleDetail);
			VegDetailDao.updateStock(saleDetail.getVegName(), stockQuantity);
		}

	}
	
	/**
	 * This method is used to return get all sales details
	 * @return
	 * @throws DBException
	 */
	public static List<SalesDetail> getAllSalesDetails() throws DBException {
		return SalesDetailsDAO.findAllSalesDetails();
	}
}
