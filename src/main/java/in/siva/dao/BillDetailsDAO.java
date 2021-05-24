package in.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.siva.exception.DBException;
import in.siva.sql.ConnectionUtil;

public class BillDetailsDAO {
	
	private BillDetailsDAO() {
		// To avoid object creation in other class
	}
	
	public static void storeSalesDetails() {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO productdetails(username, veg_price, quantity, bill, count) VALUES(?,?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);

			pst.setString(1, product.getName());
			pst.setInt(2, product.getPrice());
			pst.setInt(3, product.getQuantity());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Something went wrong! Unable to add Product");
		}

		finally {
			// Step 4: Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}
}
