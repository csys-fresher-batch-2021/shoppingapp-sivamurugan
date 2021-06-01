package in.siva.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import in.siva.constants.Constants;
import in.siva.exception.DBException;
import in.siva.model.OrderDetail;
import in.siva.model.OrderItem;
import in.siva.sql.ConnectionUtil;

public class SalesDetailsDAO {
	private SalesDetailsDAO() {
		// To avoid object creation in other class
	}
	/**
	 * This method is used to store vegetables ordered by user in  particular order id
	 * @param orderId
	 * @param vegetable
	 * @throws DBException
	 */
	public static void saveOrderItems(long orderId, OrderItem vegetable) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO order_items(order_id, veg_name, veg_price, veg_quantity, each_veg_price) VALUES(?,?,?,?,?)";
			// To Execute
			pst = connection.prepareStatement(sql);

			pst.setLong(1, orderId);
			pst.setString(2, vegetable.getVegName());
			pst.setDouble(3, vegetable.getPrice());
			pst.setInt(4, vegetable.getQuantity());
			pst.setDouble(5, vegetable.getEachVegPrice());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.COMMON_ERROR_DB);
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}
	
	/**
	 * This method is used to store order details in db 
	 * @param order
	 * @throws DBException
	 */
	public static void saveOrderDetails(OrderDetail order) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			// Query
			String sql = "INSERT INTO order_details(username, total_bill, status, active, created_date, delivery_date, payment_method, address) VALUES(?,?,?,?,?,?,?,?)";

			// To Execute
			pst = connection.prepareStatement(sql);

			pst.setString(1, order.getUsername());
			pst.setDouble(2, order.getTotalBill());
			pst.setString(3, order.getStatus());
			pst.setBoolean(4, order.isActive());
			pst.setTimestamp(5, order.getCreatedDate());
			pst.setDate(6, order.getDeliveryDate());
			pst.setString(7, order.getPaymentMethod());
			pst.setString(8, order.getAddress());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.COMMON_ERROR_DB);
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get order id of a specific order
	 * @param order
	 * @return
	 * @throws DBException
	 */
	public static Long findOrderId(OrderDetail order) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Long orderId = null;

		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();

			String sql = "SELECT order_id FROM order_details WHERE username=? and total_bill=? and created_date=? and delivery_date = ?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, order.getUsername());
			pst.setDouble(2, order.getTotalBill());
			pst.setTimestamp(3, order.getCreatedDate());
			pst.setDate(4, order.getDeliveryDate());
			
			rs = pst.executeQuery();
			if (rs.next()) {
				orderId = rs.getLong("order_id");
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.COMMON_ERROR_DB);
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}

		return orderId;
	}
	
	/**
	 * This method is used to get all order details 
	 * @return
	 * @throws DBException
	 */
	public static List<OrderDetail> findAllOrderDetails() throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<OrderDetail> orderDetails;
		try {
			orderDetails = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "SELECT * FROM order_details ORDER BY created_date DESC";

			// Execute query
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Long orderId = rs.getLong(Constants.ORDER_ID);
				String username = rs.getString(Constants.USERNAME);
				Double totalBill = rs.getDouble(Constants.TOTAL_BILL);
				String status = rs.getString(Constants.STATUS);
				Boolean active = rs.getBoolean(Constants.ACTIVE);
				Timestamp createdDate = rs.getTimestamp(Constants.ORDERED_DATE);
				Date deliveryDate = rs.getDate(Constants.DELIVERY_DATE);
				String paymentMethod = rs.getString(Constants.PAYMENT_METHOD);
				String address = rs.getString(Constants.ADDRESS);
				String cancelReason = rs.getString(Constants.CANCEL_REASON);
				
				OrderDetail order = new OrderDetail();
				
				order.setActive(active);
				order.setCreatedDate(createdDate);
				order.setDeliveryDate(deliveryDate);
				order.setFeedback(cancelReason);
				order.setPaymentMethod(paymentMethod);
				order.setStatus(status);
				order.setTotalBill(totalBill);
				order.setUsername(username);
				order.setOrderId(orderId);
				order.setAddress(address);
				
				
				orderDetails.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.FIND_ORDER_ERROR);
		}

		finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return orderDetails;
	}
	
	/**
	 * This method is used to get vegetable details of a order by order id 
	 * @param orderId
	 * @return
	 * @throws DBException
	 */
	public static List<OrderItem> findOrderItemsById(Long orderId) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<OrderItem> orderItems;
		try {
			orderItems = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "SELECT * FROM order_items WHERE order_id=?";

			// Execute query
			pst = con.prepareStatement(sql);
			pst.setLong(1, orderId);
			rs = pst.executeQuery();

			while (rs.next()) {
				String vegName = rs.getString("veg_name");
				Double vegPrice = rs.getDouble("veg_price");
				Integer vegQuantity = rs.getInt("veg_quantity");
				Double eachVegBill = rs.getDouble("each_veg_price");
				
				
				OrderItem order = new OrderItem();
				
				order.setEachVegPrice(eachVegBill);
				order.setPrice(vegPrice);
				order.setQuantity(vegQuantity);
				order.setVegName(vegName);
				
				orderItems.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.FIND_ORDER_ERROR);
		}

		finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return orderItems;
	}
	
	/**
	 * This method is used to get order details of current delivery date and pending deliveries
	 * @param date
	 * @param status
	 * @return
	 * @throws DBException
	 */
	public static List<OrderDetail> findOrdersForDelivery(Date date, String status) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<OrderDetail> orderDetails;
		try {
			orderDetails = new ArrayList<>();
			// To establish connection
			con = ConnectionUtil.getConnection();

			// SQl commands
			String sql = "SELECT * FROM order_details WHERE delivery_date = ? AND status =?";

			// Execute query
			pst = con.prepareStatement(sql);
			pst.setDate(1, date);
			pst.setString(2, status);
			rs = pst.executeQuery();

			while (rs.next()) {
				Long orderId = rs.getLong(Constants.ORDER_ID);
				String username = rs.getString(Constants.USERNAME);
				Double totalBill = rs.getDouble(Constants.TOTAL_BILL);
				String statusFromDb = rs.getString(Constants.STATUS);
				Boolean active = rs.getBoolean(Constants.ACTIVE);
				Timestamp createdDate = rs.getTimestamp(Constants.ORDERED_DATE);
				Date deliveryDate = rs.getDate(Constants.DELIVERY_DATE);
				String paymentMethod = rs.getString(Constants.PAYMENT_METHOD);
				String address = rs.getString(Constants.ADDRESS);
				String cancelReason = rs.getString(Constants.CANCEL_REASON);
				
				OrderDetail order = new OrderDetail();
				
				order.setActive(active);
				order.setCreatedDate(createdDate);
				order.setDeliveryDate(deliveryDate);
				order.setFeedback(cancelReason);
				order.setPaymentMethod(paymentMethod);
				order.setStatus(statusFromDb);
				order.setTotalBill(totalBill);
				order.setUsername(username);
				order.setOrderId(orderId);
				order.setAddress(address);
				
				
				orderDetails.add(order);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.FIND_ORDER_ERROR);
		}

		finally {
			// Close connection between java and db
			ConnectionUtil.close(rs, pst, con);
		}
		return orderDetails;
	}
	
	/**
	 * This method is used to update status of a specific order by order id
	 * @param status
	 * @param orderId
	 * @return
	 * @throws DBException
	 */
	public static boolean updateStatus(String status, Long orderId) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		boolean valid = false;
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			
			String sql = "UPDATE order_details SET status = ? WHERE order_id = ?";
			
			pst = connection.prepareStatement(sql);
			pst.setString(1, status);
			pst.setLong(2, orderId);
			pst.executeUpdate();
			valid = true;

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.COMMON_ERROR_DB);
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
		return valid;
	}
	
	/**
	 * This method is used to set order as expired if delivery date is past and status is "pending"
	 * @param previousDate
	 * @throws DBException
	 */
	public static void updateExpired(Timestamp previousDate) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		
		try {
			// To Get the connection
			connection = ConnectionUtil.getConnection();
			
			String sql = "UPDATE order_details SET status='EXPIRED' WHERE delivery_date < ? and status = 'PENDING'";
			
			pst = connection.prepareStatement(sql);
			pst.setTimestamp(1, previousDate);
			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(Constants.COMMON_ERROR_DB);
		}

		finally {
			// Release the connection
			ConnectionUtil.close(pst, connection);
		}
	}
	
}
