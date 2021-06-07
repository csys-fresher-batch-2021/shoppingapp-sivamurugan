
package in.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import in.siva.constants.Constants;
import in.siva.exception.DBException;
import in.siva.model.DiscountDetail;
import in.siva.sql.ConnectionUtil;

public class DiscountDetailDAO {
	private DiscountDetailDAO() {
		// To avoid object creation in other class
	}
	
	/**
	 * This method is used to save discount details of a order
	 * @param discount
	 * @throws DBException
	 */
	public static void save(DiscountDetail discount) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO discount_coupons(username, coupon, amount, expiry_date) VALUES(?,?,?,?)";

			// To Execute
			pst = connection.prepareStatement(sql);

			pst.setString(1, discount.getUsername());
			pst.setString(2, discount.getCoupon());
			pst.setInt(3, discount.getAmount());
			pst.setTimestamp(4, discount.getExpiryDate());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException(Constants.COMMON_ERROR_DB);
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}
	
	/**
	 * This method is used to find discount coupons for a specific user with his/ her username
	 * @param username
	 * @return
	 * @throws DBException
	 */
	public static List<DiscountDetail> findCouponsByUsername(String username) throws DBException{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<DiscountDetail> discountDetails;
		try {
			discountDetails = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "select id, coupon, amount, expiry_date from discount_coupons where username = ? and status='AVAILABLE' ORDER BY amount";

			// Execute query
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();

			while (rs.next()) {
				Long discountId = rs.getLong("id");
				String coupon = rs.getString("coupon");
				int amount = rs.getInt("amount");
				Timestamp expiryDate = rs.getTimestamp("expiry_date");
				
				DiscountDetail discountDetail = new DiscountDetail();
				
				discountDetail.setDiscountId(discountId);
				discountDetail.setAmount(amount);
				discountDetail.setCoupon(coupon);
				discountDetail.setExpiryDate(expiryDate);
				
				discountDetails.add(discountDetail);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.FIND_ORDER_ERROR);
		}

		finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return discountDetails;
	}
	
	/**
	 * This method is used to update status of a discount coupon after user uses it
	 * @param discountId
	 * @param status
	 * @return
	 * @throws DBException
	 */
	public static boolean updateStatus(long discountId, String status) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		boolean isUpdated = false;
		try {
			con = ConnectionUtil.getConnection();
			
			String sql = "UPDATE discount_coupons SET status = ? where id = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, status);
			pst.setLong(2, discountId);
			
			pst.executeUpdate();
			isUpdated = true; 
		}  catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException(Constants.COMMON_ERROR_DB);
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
		return isUpdated;
	}
}
