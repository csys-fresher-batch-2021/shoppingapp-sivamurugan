package in.siva.service;

import java.sql.SQLException;
import java.util.List;

import in.siva.dao.UserDetailDao;
import in.siva.exception.DBException;
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
	
	
	/**
	 * This method is used to add user to the ArrayList
	 * @param user
	 * @throws DBException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void addUser(UserDetail user) throws DBException{
		// Business Logic
		if (UserValidator.isUserValid(user)) {
			if (UserValidator.isUserNotRepeated(user)) {
				UserDetail validUser = changeEmailToLowerCase(user);
				UserDetailDao.addUser(validUser);
			} else {
				throw new UserRepeatedException("Sorry! Some details you entered were already registered by a user");
			}
		} else {
			throw new UserInvalidException("Invalid User Details");
		}
	}
	
	/**
	 * This method is used to verify login with role
	 * If role is admin it will validate login with admin login details
	 * If role is user it will validate login with user login details 
	 * @param username
	 * @param password
	 * @param role
	 * @return
	 * @throws DBException 
	 */

	public static String loginValidation(String username, String password, String role) throws DBException {
		String infoMessage = null;
		if(UserLoginValidator.userValidator(username, password, role)) {
			infoMessage = "Login Successful";
		} else {
			throw new InvalidLoginException("Invalid Login Credentials! Try Again");
		}
		
		return infoMessage;
	}
	
	/**
	 * This method is used to remove user by using his/ her user-name
	 * If user-name matches then matched = true and that index userDetails is removed
	 * @param username
	 * @throws DBException 
	 */
	public static void removeAccount(String username) throws DBException{
		
		if(UserValidator.isUsernamePresent(username)) {
			UserDetailDao.removeUser(username);
		} else {
			throw new UserInvalidException("User not found");
		}
	}
	
	/**
	 * This method is used to convert the email entered by user into lowercase
	 * @param user
	 * @return
	 */
	public static UserDetail changeEmailToLowerCase(UserDetail user) {
		
		String email = user.getEmail();
		email = email.toLowerCase();
		user.setEmail(email);
		return user;
	}
	
	
	/**
	 * This method is used to update name 
	 * It will check whether the username is present in db or not
	 * If username present then name is updated in db
	 * @param newName
	 * @param username
	 * @throws DBException 
	 */
	public static void updateName(String newName, String username) throws DBException {
		if(UserValidator.isUpdateNameValid(newName, username)) {
			UserDetailDao.updateName(newName, username);
		} else {
			throw new UserInvalidException("User not found");
		}
	}
	/**
	 * This method is used to provide update mobile number service
	 * It will check whether the username is present  in  db or not
	 * If username present then mobile number will be updated
	 * @param username
	 * @param newMobileNumber
	 * @throws DBException 
	 */
	public static void updateMobileNumber(long newMobileNumber, String username) throws DBException {
		if(UserValidator.isUpdateMobileValid(newMobileNumber, username)) {
			UserDetailDao.updateMobile(newMobileNumber, username);
		}
	}
	
	/**
	 * This method is used to provide update email service
	 * If entered email is valid and not repeated it will update email ID
	 * @param newEmail
	 * @param username
	 * @throws DBException
	 */
	public static void updateEmail(String newEmail, String username) throws DBException {
		if(UserValidator.isUpdateEmailValid(newEmail, username)) {
			UserDetailDao.updateEmail(newEmail, username);
		}
	}


	public static List<UserDetail> getAllUsers() throws DBException {
		return UserDetailDao.getUserDetails();
	}
	
	public static List<UserDetail> getAllUsers() throws DBException {
		return UserDetailDao.getUserDetails();
	}
	
}
