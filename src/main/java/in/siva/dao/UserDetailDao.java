package in.siva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.siva.exception.DBException;
import in.siva.model.UserDetail;
import in.siva.sql.ConnectionUtil;

public class UserDetailDao {

	private UserDetailDao() {
		// private Constructor to avoid object creation in other class
	}

	/**
	 * This method is used to add user in userdetails table in database - ShopApp
	 * 
	 * @param user
	 * @throws DBException
	 */
	public static void addUser(UserDetail user) throws DBException {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO userdetails(name, age, gender, mobile_no, email, username, password, role) VALUES(?,?,?,?,?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);

			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getGender());
			pst.setLong(4, user.getMobileNumber());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getUsername());
			pst.setString(7, user.getPassword());
			pst.setString(8, user.getRole());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Sorry! Something went wrong, Unable to create account");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method used to get user details from database It will add user details
	 * in a ArrayList and it will return that ArrayList
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<UserDetail> getUserDetails() throws DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<UserDetail> userDetails;
		try {
			userDetails = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "SELECT * FROM userdetails";

			// Execute query
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				long mobileNumber = rs.getLong("mobile_no");
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");

				UserDetail user = new UserDetail(name, age, gender, mobileNumber, email, username, password, role);

				userDetails.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Sorry! Unable to get ProductDetails");
		}

		finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return userDetails;
	}

	/**
	 * This method is used to remove a user from database
	 * 
	 * @param username
	 * @throws DBException
	 */
	public static void removeUser(String username) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "DELETE FROM userDetails WHERE username = ?";
			// To Execute
			pst = con.prepareStatement(sql);

			pst.setString(1, username);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Sorry! Unable to remove user.. Try Again!");

		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * This method is used to update a user name in database It will change user's
	 * name where username matches
	 * 
	 * @param newName
	 * @param username
	 * @throws DBException
	 */
	public static void updateName(String newName, String username) throws DBException {
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "UPDATE userdetails SET name = ? WHERE username = ?";
			// To Execute
			pst = con.prepareStatement(sql);

			pst.setString(1, newName);
			pst.setString(2, username);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Sorry! Unable to update name");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
	}
	
	/**
	 * This method is used to update user's mobile number 
	 * It will update mobile number where given username matches with database
	 * @param newNumber
	 * @param username
	 * @throws DBException
	 */
	public static void updateMobile(long newNumber, String username) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "UPDATE userdetails SET mobile_no = ? WHERE username = ?";
			// To Execute
			pst = con.prepareStatement(sql);

			pst.setLong(1, newNumber);
			pst.setString(2, username);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Sorry! Unable to update mobile Number");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
	}
	
	public static void updateEmail(String newEmail, String username) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "UPDATE userdetails SET email = ? WHERE username = ?";
			// To Execute
			pst = con.prepareStatement(sql);

			pst.setString(1, newEmail);
			pst.setString(2, username);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Sorry! Unable to update Email address");
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, con);
		}
	}
}
