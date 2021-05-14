package in.siva.validator;

import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;

import in.siva.constants.Constants;
import in.siva.model.UserDetail;
import in.siva.service.UserService;

public class UserLoginValidator {

	private UserLoginValidator() {
		// Default constructor
	}

	/**
	 * This method is used to validate user login with user name & password It will
	 * return true if user-name and password matches with user Else it will return
	 * false
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean userValidator(String username, String password, String role) {

		// Declaration
		boolean valid = false;

		// To get user details
		List<UserDetail> userDetils = UserService.getUserDetails();

		// Business Logic
		if (role.equals(Constants.USER)) {
			for (UserDetail user : userDetils) {
				if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
					valid = true;
					break;
				}
			}
		}
		return valid;
	}

	/**
	 * This method is used to validate admin login If username equal to "Admin"
	 * (Ignoring case sensitive) & password equalto "Admin123@" returns true Else it
	 * returns false
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean adminValidator(String username, String password, String role) {
		// Declaration
		boolean valid = false;

		String encryptedPassword = encryptPassword(password);
		
		// Business Logic
		if (role.equals(Constants.ADMIN) && username.equalsIgnoreCase("Admin") && checkPassword(password, encryptedPassword)) {
			valid = true;
		}
		return valid;

	}
	
	/**
	 * This method is used to encrypt password for admin
	 * @param inputPassword
	 * @return
	 */
	public static String encryptPassword(String inputPassword) {
	    StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	    return encryptor.encryptPassword(inputPassword);
	}
	
	/** 
	 * This method is used validate whether the password and encrypted password matches or not
	 * @param inputPassword
	 * @param encryptedStoredPassword
	 * @return
	 */
	public static boolean checkPassword(String inputPassword, String encryptedStoredPassword) {
	    StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	    return encryptor.checkPassword(inputPassword, encryptedStoredPassword);
	}
}
