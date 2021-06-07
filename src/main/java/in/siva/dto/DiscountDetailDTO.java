package in.siva.dto;

import java.sql.Timestamp;

import in.siva.model.DiscountDetail;

public class DiscountDetailDTO {
	private DiscountDetailDTO() {
		// To avoid object creation in other class
	}
	
	/**
	 * This method is used to convert details of a discount into a single DiscountDetail object
	 * @param username
	 * @param coupon
	 * @param amount
	 * @param expiryDateStr
	 * @return
	 */
	public static DiscountDetail setDiscountDetails(String username, String coupon, int amount, String expiryDateStr) {
		Timestamp expiryDate = Timestamp.valueOf(expiryDateStr);
		DiscountDetail discountDetail = new DiscountDetail();
		discountDetail.setUsername(username);
		discountDetail.setCoupon(coupon);
		discountDetail.setAmount(amount);
		discountDetail.setStatus("Available");
		discountDetail.setExpiryDate(expiryDate);		
		return discountDetail;
	}
}