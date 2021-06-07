package in.siva.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilValidator {

	private UtilValidator() {
		// Default constructor
	}

	/**
	 * This method is used to check the entered product has alphabets characters
	 * only If yes it returns - true, else - False;
	 * 
	 * @param productName
	 * @return
	 */
	public static boolean isStringValid(String productName) {
		String regx = "[a-z]+\\.?";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(productName);
		return matcher.find();
	}

	/**
	 * This method is used to check whether the entered quantity type is positive or
	 * not If Positive - true, Negative - false
	 * 
	 * @param productQuantity
	 * @return
	 */
	public static boolean isNumberValid(int number) {
		boolean valid = true;
		if (number < 0) {
			valid = false;
		}
		return valid;
	}

	/**
	 * This method is used to check whether the created password is valid or not It
	 * will return true if the new password contains atleast one number, lowercase,
	 * uppercase, special character Otherwise it will return false
	 * 
	 * @param password
	 * @return true or false
	 */
	public static boolean isPasswordValid(String password) {
		String check = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		Pattern passwordPattern = Pattern.compile(check);
		Matcher passwordMatcher = passwordPattern.matcher(password);
		return passwordMatcher.matches();
	}

	/**
	 * this method takes old email and new email It changes Old email into new email
	 * and it will return new email
	 * 
	 * @param email
	 * @return true or false
	 * 
	 */
	public static boolean isEmailValid(String email) {
		String check = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";

		// Business Logic
		Pattern patternForEmail = Pattern.compile(check);
		Matcher matcherForEmail = patternForEmail.matcher(email);
		return matcherForEmail.matches();
	}

	/**
	 * This method will check whether the entered user-name is valid or not User
	 * name must contain a Upper-case lower-case and a number
	 * 
	 * @param username
	 * @return
	 */
	public static boolean isUsernameValid(String username) {

		// Pattern
		String regx = "^[a-zA-Z0-9]+$";
		// Business Logic
		Pattern usernamePattern = Pattern.compile(regx);
		Matcher usernameMatcher = usernamePattern.matcher(username);
		return usernameMatcher.matches();
	}

	/**
	 * This method is used to check whether the entered mobile number is 10 digit
	 * number It will return true if length of mobile number is 10 else returns
	 * false
	 * 
	 * @param mobileNumber
	 * @return
	 */
	public static boolean isMobileValid(long mobileNumber) {
		boolean valid = false;
		String mobileStr = Long.toString(mobileNumber);
		if (mobileStr.length() == 10) {
			valid = true;
		}
		return valid;
	}

	/**
	 * This method is used to check whether the order is valid for discount or not
	 * @param amount
	 * @return
	 */
	public static boolean isCouponValid(int amount) {
		boolean valid = true;
		if (amount < 1000) {
			valid = false;
		}

		return valid;
	}

}
