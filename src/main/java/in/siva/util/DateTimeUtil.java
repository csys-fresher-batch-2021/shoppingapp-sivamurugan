package in.siva.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import in.siva.constants.Constants;

public class DateTimeUtil {
	private static final long MILLIS_IN_A_DAY = 1000 * 60 * 1440;

	private DateTimeUtil() {
		// To avoid object creation in other class
	}

	/**
	 * This method is used to get current date and Indian time of purchase
	 * 
	 * @return
	 */
	public static String getDateTime() {
		SimpleDateFormat sd = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
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
		SimpleDateFormat sd = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
		Date date = new Date();
		Date previousDate = new Date(date.getTime() - MILLIS_IN_A_DAY);
		sd.setTimeZone(TimeZone.getTimeZone("IST"));

		return sd.format(previousDate);

	}

	public static boolean isDeliveryIsAfterTodayDate(java.sql.Date deliveryDateInput) throws ParseException {
		boolean valid = false;
		String currentDateStr = getDateTime().substring(0, 10);
		String deliveryDateStr = String.valueOf(deliveryDateInput);
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date deliveryDate = sdformat.parse(deliveryDateStr);
		Date currenDate = sdformat.parse(currentDateStr);
		if (deliveryDate.compareTo(currenDate) >= 0) {
			valid = true;
		}
		return valid;
	}

	public static String getExpiryDate() {
		SimpleDateFormat sd = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
		Date date = new Date();
		Date expiryDate = new Date(date.getTime() + MILLIS_IN_A_DAY * 60);
		sd.setTimeZone(TimeZone.getTimeZone("IST"));

		return sd.format(expiryDate);
	}
}
