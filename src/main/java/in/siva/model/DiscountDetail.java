package in.siva.model;

import java.sql.Timestamp;
public class DiscountDetail {
	private long discountId;
	private String username;
	private String coupon;
	private int amount;
	private String status;
	private Timestamp expiryDate;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	public long getDiscountId() {
		return discountId;
	}
	public void setDiscountId(long discountId) {
		this.discountId = discountId;
	}	
	@Override
	public String toString() {
		return "DiscountDetail [discountId=" + discountId + ", username=" + username + ", coupon=" + coupon
				+ ", amount=" + amount + ", status=" + status + ", expiryDate=" + expiryDate + "]";
	}
	
	
}