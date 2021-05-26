package in.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.siva.exception.DBException;
import in.siva.model.SalesDetail;
import in.siva.sql.ConnectionUtil;

public class SalesDetailsDAO {
	private SalesDetailsDAO(){
		// To avoid object creation in other class
	}
	
	/**
	 * This method is used to save salesDetails in db
	 * @param salesDetail
	 * @throws DBException
	 */
	public static void save(SalesDetail salesDetail) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO sales_details(username, veg_name, veg_price, veg_quantity, each_veg_bill, date_time) VALUES(?,?,?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);

			pst.setString(1, salesDetail.getUsername());
			pst.setString(2, salesDetail.getVegName());
			pst.setDouble(3, salesDetail.getVegPrice());
			pst.setInt(4, salesDetail.getQuantity());
			pst.setDouble(5, salesDetail.getEachPrice());
			pst.setTimestamp(6,salesDetail.getDateTime());

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
}
