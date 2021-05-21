package in.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.siva.exception.DBException;
import in.siva.model.ProductDetail;
import in.siva.sql.ConnectionUtil;

public class ProductDetailDao {

	private ProductDetailDao() {
		// Default constructor
	}

	/**
	 * This method is used to add product in database
	 * 
	 * @param product
	 * @throws DBException
	 */
	public static void addProduct(ProductDetail product) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO productdetails(name, price, quantity) VALUES(?,?,?)";
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

	/**
	 * This method is used to get product details from database It will add database
	 * product details in a ArrayList Then it will return the ArrayList
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<ProductDetail> getProductDetails() throws DBException {

		List<ProductDetail> productDetails;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			productDetails = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "SELECT * FROM productdetails";

			// Execute query
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");

				ProductDetail product = new ProductDetail(name, price, quantity);

				productDetails.add(product);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Something went Wrong! Unable to get Product Details");
		} finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return productDetails;
	}

	/**
	 * This method is used to remove a product from database with product name
	 * 
	 * @param name
	 * @throws DBException
	 */
	public static void removeProduct(String name) throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "DELETE FROM productdetails WHERE name = ?";
			// To Execute
			pst = con.prepareStatement(sql);

			pst.setString(1, name);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Something went wrong! Unable to remove Product");
		} finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
	}
}
