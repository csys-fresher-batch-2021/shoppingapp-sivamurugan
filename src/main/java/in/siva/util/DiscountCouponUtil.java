package in.siva.util;
public class DiscountCouponUtil {
	private DiscountCouponUtil() {
		// To avoid object creation
	}

	/**
	 * This method is used to generate a 10 digit random coupon code
	 * @return
	 */
	public static String generateCoupon() {
 		// choose a Character random from this String
		String availableCharacters = "ABCDEFGHIJKLMNPQRSTUVWXYZ" + "123456789";

		// create StringBuffer 
		StringBuilder sb = new StringBuilder(5);

		for (int i = 0; i < 15; i++) {

			// generate a random number
			double indexDouble = availableCharacters.length() * Math.random();
			int index = (int)Math.round(indexDouble);
			if(index > 0 && index < 33) {
				sb.append(availableCharacters.charAt(index));
			}
		}

		return sb.toString().substring(0,10);
		
	}
	
	/**
	 * This method is used to find discount amount for a particular order
	 * @param amount
	 * @return
	 */
	public static int findDiscountAmount(int amount) {
		int discount = 0;
		if(amount < 2000 && amount >= 1000) {
			discount = 50;
		}
		else if(amount < 3000 && amount >= 2000) {
			discount = 150;
		}
		else if(amount < 4000 && amount >= 3000) {
			discount = 300;
		}
		else if(amount <5000 && amount >= 4000) {
			discount = 450;
		}
		else if(amount >= 5000) {
			discount = 600;
		}
		return discount;
	}
}
