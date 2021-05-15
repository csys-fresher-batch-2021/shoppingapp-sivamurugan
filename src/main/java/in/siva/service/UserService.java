package in.siva.service;

import java.util.ArrayList;
import java.util.List;

import in.siva.exception.InvalidLoginException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;
import in.siva.model.UserDetail;
import in.siva.validator.UserLoginValidator;
import in.siva.validator.UserValidator;

public class UserService {

	private UserService() {
		// Default constructor
	}

	// Global ArrayList declaration to store user details
	private static final List<UserDetail> userDetails = new ArrayList<>();
	
	/** 
	 * This method is used to get user details
	 * @return userDetails
	 */
	public static List<UserDetail> getUserDetails() {
		return userDetails;
	}
	
	
	/**
	 * This method is used to add user to the ArrayList
	 * @param user
	 */
	public static void addUser(UserDetail user) {
		// Business Logic
		if (UserValidator.isUserValid(user)) {
			if (UserValidator.isUserNotRepeated(user)) {
				userDetails.add(user);
			} else {
				throw new UserRepeatedException("Sorry! Some details you entered were already registered by a user");
			}
		} else {
			throw new UserInvalidException("Invalid User Details");
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * This method is used to verify login with role
	 * If role is admin it will validate login with admin login details
	 * If role is user it will validate login with user login details 
=======
	/**
	 * This method is used to validate the user with admin and normal user role
	 * If user didn't met normal login and admin login it will throw Invalid login details exception
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
	 * @param username
	 * @param password
	 * @param role
	 * @return
<<<<<<< HEAD
=======
	 */
	public static String loginValidation(String username, String password, String role) {
		String infoMessage = null;
		if(UserLoginValidator.userValidator(username, password, role)) {
			infoMessage = "User Login Successful";
		} else if(UserLoginValidator.adminValidator(username, password, role)) {
			infoMessage = "Admin Login Successful";
		} else {
			throw new InvalidLoginException("Invalid Login Credentials! Try Again");
		}
		
		return infoMessage;
	}

	/** 
	 * This method is used to get user details
	 * @return userDetails
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
	 */
	public static String loginValidation(String username, String password, String role) {
		String infoMessage = null;
		if(UserLoginValidator.userValidator(username, password, role)) {
			infoMessage = "User Login Sucessful";
		} else if(UserLoginValidator.adminValidator(username, password, role)) {
			infoMessage = "Admin Login Successful";
		} else {
			throw new InvalidLoginException("Invalid Login Credentials! Try Again");
		}
		
		return infoMessage;
	}
	
}
