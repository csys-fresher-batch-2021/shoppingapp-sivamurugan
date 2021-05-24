package in.siva.dto;

import java.sql.Timestamp;

import in.siva.model.BillDetail;
import in.siva.model.SalesDetail;

public class SalesDetailDTO {
	private SalesDetailDTO() {
		// To avoid object creation in other class
	}
	
	public static SalesDetail setSalesDetail(BillDetail vegDetail, String username, String dateTime) {
		String vegName = vegDetail.getVegName();
		double vegPrice = (double)vegDetail.getPrice();
		int vegQuantity = vegDetail.getQuantity();
		double eachVegBill = vegDetail.getEachVegBill();
		Timestamp dateTimeDb = Timestamp.valueOf(dateTime);
		SalesDetail orderDetail = new SalesDetail();
		orderDetail.setUsername(username);
		orderDetail.setVegName(vegName);
		orderDetail.setVegPrice(vegPrice);
		orderDetail.setQuantity(vegQuantity);
		orderDetail.setEachPrice(eachVegBill);
		orderDetail.setDateTime(dateTimeDb);
		
		return orderDetail;
	}
}
