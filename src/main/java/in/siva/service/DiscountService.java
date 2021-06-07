package in.siva.service;

import java.util.List;

import in.siva.dao.DiscountDetailDAO;
import in.siva.dao.SalesDetailsDAO;
import in.siva.dto.DiscountDetailDTO;
import in.siva.exception.DBException;
import in.siva.exception.NoDiscountFoundException;
import in.siva.model.DiscountDetail;
import in.siva.util.DateTimeUtil;
import in.siva.util.DiscountCouponUtil;
import in.siva.validator.UtilValidator;

public class DiscountService {

	private DiscountService() {
		// To avoid object creation in other class
	}
	
	/**
	 * This method is used to generate coupon for a particular order and store it in DB
	 * @param username
	 * @param orderId
	 * @return
	 * @throws DBException
	 */
	public static boolean isDiscountCouponStored(String username, long orderId) throws DBException {
		boolean valid = false;
		int amount = SalesDetailsDAO.findTotalBill(orderId);
		if (UtilValidator.isCouponValid(amount)) {
			String coupon = DiscountCouponUtil.generateCoupon();
			int discountAmount = DiscountCouponUtil.findDiscountAmount(amount);
			String expiryDate = DateTimeUtil.getExpiryDate();
			DiscountDetail discountDetail = DiscountDetailDTO.setDiscountDetails(username, coupon, discountAmount,
					expiryDate);
			DiscountDetailDAO.save(discountDetail);
			valid = true;
		}
		return valid;
	}

	/**
	 * This method is used to get discount coupon details 
	 * @param username
	 * @return
	 * @throws DBException
	 * @throws NoDiscountFoundException
	 */
	public static List<DiscountDetail> getCoupons(String username) throws DBException, NoDiscountFoundException {
		List<DiscountDetail> coupons = DiscountDetailDAO.findCouponsByUsername(username);
		if (coupons.isEmpty()) {
			throw new NoDiscountFoundException("Discount Coupons not available for this user");
		}
		return coupons;
	}
	
	/**
	 * This method is used to change status of a particular discount
	 * @param discountId
	 * @param status
	 * @return
	 * @throws DBException
	 */
	public static boolean changeStatus(long discountId, String status) throws DBException {
		boolean valid=false;
		if(DiscountDetailDAO.updateStatus(discountId, status)) {
			valid = true;
		}
		return valid;
	}
}
