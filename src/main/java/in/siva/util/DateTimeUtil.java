package in.siva.util;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateTimeUtil {
	private DateTimeUtil() {
		// To avoid object creation in other class
	}

	/**
	 * This method is used to get current date and Indian time of purchase
	 * @return
	 */
	public static String getDateTime() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		
		return sd.format(date);
	}
	
}
