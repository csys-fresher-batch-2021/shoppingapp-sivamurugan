package in.siva.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import in.siva.dao.VegDetailDAO;
import in.siva.dao.SalesDetailsDAO;
import in.siva.dto.BillDetailsDTO;
import in.siva.dto.SalesDetailDTO;
import in.siva.exception.DBException;
import in.siva.exception.EmptyBillException;
import in.siva.exception.EmptyOrderException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.VegInvalidException;
import in.siva.logics.BillCalculator;
import in.siva.model.BillDetail;
import in.siva.model.OrderDetail;
import in.siva.model.OrderItem;
import in.siva.util.DateTimeUtil;
import in.siva.validator.BillValidator;
import in.siva.validator.UserValidator;
import in.siva.validator.UtilValidator;
import in.siva.validator.VegetableValidator;

public class SalesService {
	private SalesService() {
		// To avoid object creation in other class
	}

	/**
	 * This method is used to get bill amount for selected vegetables and quantities
	 * 
	 * @param selectedVegs
	 * @param quantities
	 * @return
	 * @throws EmptyBillException
	 * @throws DBException
	 * @throws Exception
	 */
	public static List<BillDetail> getBill(String[] selectedVegs, String[] quantities)
			throws DBException, EmptyBillException {

		// To get bill for each vegetable
		List<Double> billForEachVeg = BillCalculator.billForEachVegetable(selectedVegs, quantities);

		// To get bill details
		List<BillDetail> billDetails = BillDetailsDTO.getBillForVeg(selectedVegs, quantities, billForEachVeg);

		// Bill validation
		BillValidator.isBillValid(billDetails);

		return billDetails;

	}

	/**
	 * This method is used to get total bill amount of a purchase
	 * 
	 * @param billDetails
	 * @return
	 */
	public static double getTotalBill(List<BillDetail> billDetails) {
		return BillCalculator.getTotalBill(billDetails);
	}

	/**
	 * This method is used to get date and time of purchase
	 * 
	 * @return
	 */
	public static String getDateTime() {
		return DateTimeUtil.getDateTime();
	}

	/**
	 * This method is used to get new stock quantity after purchase
	 * 
	 * @param saleDetail
	 * @return
	 * @throws DBException
	 */
	public static int getNewStockQuantity(OrderItem vegetable) throws DBException {
		int stockQuantity = VegDetailDAO.findStockByName(vegetable.getVegName());
		return (stockQuantity - vegetable.getQuantity());

	}

	/**
	 * This method is used to store salesDetails of a purchase after order confirmed
	 * 
	 * @param username
	 * @param billDetails
	 * @throws DBException
	 */
	public static void storeOrderDetails(String username, List<BillDetail> billDetails, String paymentMethod,
			String deliveryDateStr, String deliveryAddress) throws DBException {
		Timestamp createdDateTime = Timestamp.valueOf(getDateTime());
		Date deliveryDate = Date.valueOf(deliveryDateStr);
		double totalBill = getTotalBill(billDetails);

		OrderDetail orderDetails = SalesDetailDTO.setOrderDetailsForDb(username, totalBill, createdDateTime,
				deliveryDate, paymentMethod, deliveryAddress);

		SalesDetailsDAO.saveOrderDetails(orderDetails);
		Long orderId = SalesDetailsDAO.findOrderId(orderDetails);

		storeOrderItems(billDetails, orderId);

	}

	/**
	 * This method is used to get all order details from DAO
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<OrderDetail> getAllOrderDetails() throws DBException {
		List<OrderDetail> orderDetails = SalesDetailsDAO.findAllOrderDetails();
		List<OrderDetail> orderDetailsForOutput = new ArrayList<>();
		for (OrderDetail order : orderDetails) {
			Long orderId = order.getOrderId();
			List<OrderItem> orderItems = SalesDetailsDAO.findOrderItemsById(orderId);
			OrderDetail orderDetail = SalesDetailDTO.setOrderDetailsForOutput(order, orderItems);
			orderDetailsForOutput.add(orderDetail);
		}
		return orderDetails;
	}

	public static void storeOrderItems(List<BillDetail> billDetails, Long orderId) throws DBException {
		List<OrderItem> orderItemList = SalesDetailDTO.setOrderItems(billDetails);
		for (OrderItem orderItem : orderItemList) {
			if (VegetableValidator.isVegMatches(orderItem.getVegName())) {
				int newStockQuantity = getNewStockQuantity(orderItem);
				VegDetailDAO.updateStock(orderItem.getVegName(), newStockQuantity);
				SalesDetailsDAO.saveOrderItems(orderId, orderItem);
			} else {
				throw new VegInvalidException("Invalid Vegetale Selected");
			}
		}
	}

	/**
	 * This method is used to get current date pending deliveries from DAO
	 * 
	 * @return
	 * @throws DBException
	 */
	public static List<OrderDetail> getCurrentDeliveryOrders() throws DBException {
		String dateTime = DateTimeUtil.getDateTime();
		Date date = Date.valueOf(dateTime.substring(0, 10));
		String status = "PENDING";
		List<OrderDetail> orderDetails = SalesDetailsDAO.findOrdersForDelivery(date, status);
		List<OrderDetail> orderDetailsForOutput = new ArrayList<>();

		for (OrderDetail order : orderDetails) {
			Long orderId = order.getOrderId();
			List<OrderItem> orderItems = SalesDetailsDAO.findOrderItemsById(orderId);
			OrderDetail orderDetail = SalesDetailDTO.setOrderDetailsForOutput(order, orderItems);
			orderDetailsForOutput.add(orderDetail);
		}
		return orderDetailsForOutput;
	}

	/**
	 * This method is used to set status of order as delivered
	 * 
	 * @param orderId
	 * @return
	 * @throws DBException
	 */
	public static boolean setStatusAsDelivered(Long orderId) throws DBException {
		boolean valid = false;
		if (SalesDetailsDAO.updateStatus("DELIVERED", orderId)) {
			valid = true;
		}

		return valid;
	}

	/**
	 * This method is used to set status of order as canceled
	 * 
	 * @param orderId
	 * @return
	 * @throws DBException
	 */
	public static boolean setStatusAsCanceled(Long orderId) throws DBException {
		boolean valid = false;
		if (SalesDetailsDAO.updateStatus("CANCELED", orderId)) {
			valid = true;
		}

		return valid;
	}

	/**
	 * This method is used to set order as expired if delivery date is past and
	 * order is not delivered
	 * 
	 * @throws DBException
	 */
	public static void updateExpiredOrder() throws DBException {
		Timestamp dateTime = Timestamp.valueOf(DateTimeUtil.getPreviousDate());
		SalesDetailsDAO.updateExpired(dateTime);
	}

	/**
	 * This method is used to get specific user's orders
	 * 
	 * @param username
	 * @return
	 * @throws DBException
	 * @throws EmptyOrderException
	 */
	public static List<OrderDetail> getMyOrders(String username) throws DBException {
		List<OrderDetail> orderDetails;
		List<OrderDetail> orderDetailsForOutput;
		if (UserValidator.isUsernamePresent(username)) {
			orderDetails = SalesDetailsDAO.findOrdersByUsername(username);
			orderDetailsForOutput = new ArrayList<>();

			for (OrderDetail order : orderDetails) {
				Long orderId = order.getOrderId();
				List<OrderItem> orderItems = SalesDetailsDAO.findOrderItemsById(orderId);
				OrderDetail orderDetail = SalesDetailDTO.setOrderDetailsForOutput(order, orderItems);
				orderDetailsForOutput.add(orderDetail);
			}
		} else {
			throw new UserInvalidException("Please Login to see Your order details");
		}
		System.out.println(orderDetailsForOutput);
		return orderDetailsForOutput;
	}
	
	public static void main(String[] args) throws DBException, EmptyOrderException {
		System.out.println(getMyOrders("rakas"));
	}
}
