package in.siva.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import in.siva.exception.DBException;
import in.siva.model.SalesDetail;
import in.siva.sql.ConnectionUtil;

public class SalesDetailsDAO {
	private SalesDetailsDAO() {
		// To avoid object creation in other class
	}

	/**
	 * This method is used to save salesDetails in db
	 * 
	 * @param salesDetail
	 * @throws DBException
	 */
	public static void saveSalesDetails(SalesDetail salesDetail) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO sales_details(username, veg_name, veg_price, veg_quantity, each_veg_bill, date_time, delivery_date, payment, status) VALUES(?,?,?,?,?,?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);

			pst.setString(1, salesDetail.getUsername());
			pst.setString(2, salesDetail.getVegName());
			pst.setDouble(3, salesDetail.getVegPrice());
			pst.setInt(4, salesDetail.getQuantity());
			pst.setDouble(5, salesDetail.getEachPrice());
			pst.setTimestamp(6, salesDetail.getDateTime());
			pst.setDate(7, salesDetail.getDeliveryDate());
			pst.setString(8, salesDetail.getPaymentMethod());
			pst.setString(9, salesDetail.getStatus());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Something went wrong!");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get all sales details in a list of SalesDetail Object
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<SalesDetail> findAllSalesDetails() throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<SalesDetail> salesDetails;
		try {
			salesDetails = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "SELECT * FROM sales_details ORDER BY date_time DESC";

			// Execute query
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String vegName = rs.getString("veg_name");
				double vegPrice = rs.getDouble("veg_price");
				int vegQuantity = rs.getInt("veg_quantity");
				double eachVegPrice = rs.getDouble("each_veg_bill");
				Timestamp dateTime = rs.getTimestamp("date_time");
				Date date = rs.getDate("delivery_date");
				String payment = rs.getString("payment");
				String status = rs.getString("status");

				SalesDetail orderDetails = new SalesDetail();
				orderDetails.setUsername(username);
				orderDetails.setDateTime(dateTime);
				orderDetails.setEachPrice(eachVegPrice);
				orderDetails.setQuantity(vegQuantity);
				orderDetails.setVegName(vegName);
				orderDetails.setVegPrice(vegPrice);
				orderDetails.setDeliveryDate(date);
				orderDetails.setPaymentMethod(payment);
				orderDetails.setStatus(status);

				salesDetails.add(orderDetails);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Sorry! Unable to get sales details");
		}

		finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return salesDetails;
	}
}
