package in.siva.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.TimeZone;

import in.siva.service.SalesService;

public class DateTimeUtil {
	private DateTimeUtil() {
		// To avoid object creation in other class
	}

	public static String getDateTime() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		
		return sd.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(getDateTime());
	}
}
