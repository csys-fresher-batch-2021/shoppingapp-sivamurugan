package in.siva.dto;

import java.sql.Timestamp;

import in.siva.model.BillDetail;
import in.siva.model.SalesDetail;

public class SalesDetailDTO {
	private SalesDetailDTO() {
		// To avoid object creation in other class
	}
	
	/**
	 * This method sets username of the purchasing user and bill details in a object and returns it 
	 * @param vegDetail
	 * @param username
	 * @param dateTime
	 * @return
	 */
	public static SalesDetail setSalesDetail(BillDetail vegDetail, String username, String dateTime) {
		
		// To obtain required paramaters
		String vegName = vegDetail.getVegName();
		double vegPrice = (double)vegDetail.getPrice();
		int vegQuantity = vegDetail.getQuantity();
		double eachVegBill = vegDetail.getEachVegBill();
		Timestamp dateTimeDb = Timestamp.valueOf(dateTime);
		
		// To create object for sales details of user
		SalesDetail orderDetail = new SalesDetail();
		
		// To add values in object
		orderDetail.setUsername(username);
		orderDetail.setVegName(vegName);
		orderDetail.setVegPrice(vegPrice);
		orderDetail.setQuantity(vegQuantity);
		orderDetail.setEachPrice(eachVegBill);
		orderDetail.setDateTime(dateTimeDb);
		
		return orderDetail;
	}
}
