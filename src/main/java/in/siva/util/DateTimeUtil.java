package in.siva.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
	private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

	private DateTimeUtil() {
		// To avoid object creation in other class
	}

	/**
	 * This method is used to get current date and Indian time of purchase
	 * 
	 * @return
	 */
	public static String getDateTime() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));

		return sd.format(date);
	}

	/**
	 * This method is used to get previous date
	 * 
	 * @return
	 */
	public static String getPreviousDate() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Date previousDate = new Date(date.getTime() - MILLIS_IN_A_DAY);
		sd.setTimeZone(TimeZone.getTimeZone("IST"));

		return sd.format(previousDate);

	}
}
