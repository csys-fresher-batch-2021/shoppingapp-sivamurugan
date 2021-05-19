package in.siva.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	private ConnectionUtil() {
		// Default constructor
	}
	
	/**
	 * This method is used to establish connection between java and database
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/ShopApp";
		String username = "postgres";
		String password = "Sivamurugan";
		
		// To Load the jdbc driver in memory
		Class.forName(driverClass);
		// To Get the connection
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * This method is used to close connection between java and database
	 * @param connection
	 */
	public static void close( PreparedStatement statement, Connection connection) {
		try {
			if(statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Method overloading to close connection
	 */
	public static void close(ResultSet rs, PreparedStatement statement, Connection connection) {
		try {
			
			if(rs != null) {
				rs.close();
			}
			if(statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
