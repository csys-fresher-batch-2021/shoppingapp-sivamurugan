package in.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.siva.exception.DBException;
import in.siva.model.VegDetail;
import in.siva.sql.ConnectionUtil;

public class VegDetailDAO {
	private VegDetailDAO() {
		// private constructor to avoid object creation in other class
	}
	/**
	 * This method is used to add vegetables in database
	 * 
	 * @param vegetable
	 * @throws DBException
	 */
	public static void saveVeg(VegDetail vegetable) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO veg_details(name, price, quantity) VALUES(?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);
			pst.setString(1, vegetable.getName());
			pst.setInt(2, vegetable.getPrice());
			pst.setInt(3, vegetable.getQuantity());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Something went wrong! Unable to add Vegetable");
		}
		finally {
			// Step 4: Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get vegetable details from database It will add database
	 * vegetable details in a ArrayList Then it will return the ArrayList
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<VegDetail> findAll() throws DBException {
		List<VegDetail> vegDetails;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			vegDetails = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();
			// SQl commands
			String sql = "SELECT * FROM veg_details ORDER BY name";
			// Execute query
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				VegDetail vegetable = new VegDetail(name, price, quantity);
				vegDetails.add(vegetable);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Something went Wrong! Unable to get Vegetable Details");
		} finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return vegDetails;
	}

	/**
	 * This method is used to remove a vegetable from database with vegetable name
	 * 
	 * @param name
	 * @throws DBException
	 */
	public static void deleteVegByName(String name) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();
			// SQl commands
			String sql = "DELETE FROM veg_details WHERE name = ?";
			// To Execute
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Something went wrong! Unable to remove vegetable");
		} finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
	}
	
	/**
	 * This method is used to get vegetable price by vegetable name
	 * @param name
	 * @return
	 * @throws DBException
	 */
	public static int findPriceByName(String name) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer price = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();			
			// SQL query
			String sql = "SELECT price FROM veg_details WHERE name= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			// execute query
			rs = pst.executeQuery();
			if(rs.next()) {
				price = rs.getInt("price");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Something went wrong! Unable to get price");
		} finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
		return price;
	}
	
	/**
	 * This method is used to get vegetable stock quantity by vegetable name 
	 * @param name
	 * @return
	 * @throws DBException
	 */
	public static int findStockByName(String name) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer quantity = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();			
			// SQL query
			String sql = "SELECT quantity FROM veg_details WHERE name= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			// To execute query
			rs = pst.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt("quantity");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Something went wrong! Unable to get stock quantity");
		} finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
		return quantity;
	}
	
	/**
	 * This method is used to update stock quantity by vegetable name 
	 * @param name
	 * @param newStock
	 * @throws DBException
	 */
	public static void updateStock(String name, int newStock) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();
			// SQl commands
			String sql = "UPDATE veg_details SET quantity = ? WHERE name = ?";
			// To Execute
			pst = con.prepareStatement(sql);
			pst.setInt(1, newStock);
			pst.setString(2, name);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Sorry! Something went wrong.. Unable to update stock");
		}
		finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}	
	}
}
