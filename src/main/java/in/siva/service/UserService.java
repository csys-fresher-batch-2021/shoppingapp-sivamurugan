package in.siva.service;

import java.sql.SQLException;
import java.util.List;

import in.siva.dao.UserDetailDAO;
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
	 * @throws UserRepeatedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void addUser(UserDetail user) throws DBException, UserRepeatedException{
		// Business Logic
		if (UserValidator.isUserValid(user)) {
			if (UserValidator.isUserNotRepeated(user)) {
				UserDetail validUser = changeEmailToLowerCase(user);
				UserDetailDAO.addUser(validUser);
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

	public static String loginValidation(String username, String password) throws DBException {
		String role = null;
		if(UserLoginValidator.userValidator(username, password)) {
			role = UserDetailDAO.getRole(username, password);
		} else {
			throw new InvalidLoginException("Invalid Login Credentials! Try Again");
		}
		
		return role;
	}
	
	/**
	 * This method is used to remove user by using his/ her user-name
	 * If user-name matches then matched = true and that index userDetails is removed
	 * @param username
	 * @throws DBException 
	 */
	public static void removeAccount(String username) throws DBException{
		
		if(UserValidator.isUsernamePresent(username)) {
			UserDetailDAO.removeUser(username);
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
			UserDetailDAO.updateName(newName, username);
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
	 * @throws UserRepeatedException 
	 */
	public static void updateMobileNumber(long newMobileNumber, String username) throws DBException, UserRepeatedException {
		if(UserValidator.isUpdateMobileValid(newMobileNumber, username)) {
			UserDetailDAO.updateMobile(newMobileNumber, username);
		}
	}
	
	/**
	 * This method is used to provide update email service
	 * If entered email is valid and not repeated it will update email ID
	 * @param newEmail
	 * @param username
	 * @throws DBException
	 * @throws UserRepeatedException 
	 */
	public static void updateEmail(String newEmail, String username) throws DBException, UserRepeatedException {
		if(UserValidator.isUpdateEmailValid(newEmail, username)) {
			UserDetailDAO.updateEmail(newEmail, username);
		}
	}


	/**
	 * This method is used to get all user details from DAO
	 * @return
	 * @throws DBException
	 */
	public static List<UserDetail> getAllUsers() throws DBException {
		return UserDetailDAO.getUserDetails();
	}
	
}
