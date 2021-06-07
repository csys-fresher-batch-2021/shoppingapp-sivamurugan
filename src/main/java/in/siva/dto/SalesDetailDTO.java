package in.siva.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import in.siva.model.BillDetail;
import in.siva.model.OrderDetail;
import in.siva.model.OrderItem;

public class SalesDetailDTO {
	private SalesDetailDTO() {
		// To avoid object creation in other class
	}

	/**
	 * This method adds vegetable details in order details for output (FrontEnd)
	 * @param orderDetail
	 * @param orderItems
	 * @return
	 */
	public static OrderDetail setOrderDetailsForOutput(OrderDetail orderDetail, List<OrderItem> orderItems) {
		orderDetail.setOrderItems(orderItems);
		return orderDetail;
	}

	/**
	 * This method is used to set vegetable details of order into orderDetails 
	 * @param vegDetails
	 * @return
	 */
	public static List<OrderItem> setOrderItems(List<BillDetail> vegDetails) {
		List<OrderItem> orderItemList = new ArrayList<>();
		for (BillDetail vegDetail : vegDetails) {
			String vegName = vegDetail.getVegName();
			double vegPrice = (double) vegDetail.getPrice();
			int vegQuantity = vegDetail.getQuantity();
			double eachVegBill = vegDetail.getEachVegBill();
			// To create object for order items
			OrderItem vegetable = new OrderItem();
			vegetable.setVegName(vegName);
			vegetable.setPrice(vegPrice);
			vegetable.setQuantity(vegQuantity);
			vegetable.setEachVegPrice(eachVegBill);
			orderItemList.add(vegetable);
		}
		return orderItemList;
	}

	/**
	 * This method is used to set order details in a object to pass to DAO
	 * @param username
	 * @param totalBill
	 * @param createdDateTime
	 * @param deliveryDate
	 * @param paymentMethod
	 * @return
	 */
	public static OrderDetail setOrderDetailsForDb(String username, double totalBill, Timestamp createdDateTime,
			Date deliveryDate, String paymentMethod, String deliveryAddress) {
		// To create object for order details of user
		OrderDetail orderDetail = new OrderDetail();
		// To add values in object
		orderDetail.setCreatedDate(createdDateTime);
		orderDetail.setUsername(username);
		orderDetail.setTotalBill(totalBill);
		orderDetail.setPaymentMethod(paymentMethod);
		orderDetail.setDeliveryDate(deliveryDate);
		orderDetail.setAddress(deliveryAddress);
		return orderDetail;
	}

}
