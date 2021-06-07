package in.siva.validator;

import java.util.List;
import in.siva.dao.UserDetailDAO;
import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;
import in.siva.model.UserDetail;

public class UserValidator {

	private UserValidator() {
		// Default constructor
	}

	/**
	 * This method is used to validate whether the details entered by user is valid
	 * or not It will validate all details and if all details are valid it will
	 * return true else it will return false
	 * 
	 * @param user
	 * @return
	 */
	public static boolean isUserValid(UserDetail user) {
		// Declaration
		boolean valid = false;
		// Business Logic
		if (UtilValidator.isStringValid(user.getName()) && UtilValidator.isNumberValid(user.getAge())
				&& UtilValidator.isEmailValid(user.getEmail()) && UtilValidator.isMobileValid(user.getMobileNumber())
				&& UtilValidator.isUsernameValid(user.getUsername())
				&& UtilValidator.isPasswordValid(user.getPassword())) {
			valid = true;
		}
		return valid;
	}

	/**
	 * This method is used to check whether the sensitive details entered by user is
	 * already registered by a user or not If not used by it will return true Else
	 * it will return false
	 * 
	 * @param user
	 * @return
	 * @throws DBException
	 * @throws UserRepeatedException 
	 */
	public static boolean isUserNotRepeated(UserDetail user) throws DBException, UserRepeatedException {
		// Declaration
		boolean valid = false;
		// To get user details
		List<UserDetail> userDetails = UserDetailDAO.getUserDetails();
		// Business Logic
		for (UserDetail userDetail : userDetails) {
			if (!user.getEmail().equalsIgnoreCase(userDetail.getEmail())) {
				if (userDetail.getMobileNumber() != user.getMobileNumber()) {
					if (!user.getUsername().equals(userDetail.getUsername())) {
						valid = true;
					} else {
						throw new UserRepeatedException(
								"Sorry! This username is already used by a user try another username");
					}

				} else {
					throw new UserRepeatedException(
							"Sorry! This mobile number is already used by a user. Try another mobile number");
				}

			} else {
				throw new UserRepeatedException("Sorry! This email is already used by a user. Try another email");
			}
		}
		return valid;
	}

	/**
	 * This method is used to check whether the username is present in database or
	 * not If present - true if not present - false
	 * 
	 * @param username
	 * @return
	 * @throws DBException
	 */
	public static boolean isUsernamePresent(String username) throws DBException {
		boolean exists = false;
		List<UserDetail> userDetails = UserDetailDAO.getUserDetails();
		for (UserDetail user : userDetails) {
			if (user.getUsername().equals(username)) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	/**
	 * This method is used to check whether the entered mobile number is already
	 * present in db or not
	 * 
	 * @param mobileNumber
	 * @return
	 * @throws DBException
	 */
	public static boolean isMobileNotRepeated(long mobileNumber) throws DBException {
		boolean isNotRepeated = true;
		List<UserDetail> userDetails = UserDetailDAO.getUserDetails();
		for (UserDetail user : userDetails) {
			if (user.getMobileNumber() == mobileNumber) {
				isNotRepeated = false;
				break;
			}
		}
		return isNotRepeated;
	}

	/**
	 * This method is used to check whether the email by user is already used by
	 * another user or not If used it will return false Else it will return true
	 * 
	 * @param email
	 * @return
	 * @throws DBException
	 */
	public static boolean isEmailNotRepeated(String email) throws DBException {
		boolean isNotRepeated = true;
		List<UserDetail> userDetails = UserDetailDAO.getUserDetails();
		for (UserDetail user : userDetails) {
			if (user.getEmail().equals(email)) {
				isNotRepeated = false;
				break;
			}
		}
		return isNotRepeated;
	}

	/**
	 * This method is used to check whether the entered username & new name is valid
	 * or not Returns true if valid else returns false
	 * 
	 * @param newName
	 * @param username
	 * @return
	 * @throws DBException
	 */
	public static boolean isUpdateNameValid(String newName, String username) throws DBException {
		boolean valid = false;
		if (UtilValidator.isStringValid(newName) && isUsernamePresent(username)) {
			valid = true;
		}
		return valid;
	}

	/**
	 * This method is used to check whether entered mobile number is valid or not
	 * Returns true if mobile number & username is present in db Else it returns
	 * false
	 * 
	 * @param newNumber
	 * @param username
	 * @return
	 * @throws DBException
	 * @throws UserRepeatedException 
	 */
	public static boolean isUpdateMobileValid(long newNumber, String username) throws DBException, UserRepeatedException {
		boolean valid = false;
		if (UtilValidator.isMobileValid(newNumber)) {
			if (isMobileNotRepeated(newNumber)) {
				if (isUsernamePresent(username)) {
					valid = true;
				} else {
					throw new UserInvalidException("User not found");
				}
			} else {
				throw new UserRepeatedException("Mobile Number is already used by a user");
			}

		} else {
			throw new UserInvalidException("Please enter valid mobile number");
		}
		return valid;
	}

	/**
	 * This method is used to validate whether the email is valid to add in database
	 * or not It will validate whether email is valid or not, email ID is repeated
	 * or not, username is available in db or not
	 * 
	 * @param newEmail
	 * @param username
	 * @return
	 * @throws DBException
	 * @throws UserRepeatedException 
	 */
	public static boolean isUpdateEmailValid(String newEmail, String username) throws DBException, UserRepeatedException {
		boolean valid = false;
		if (UtilValidator.isEmailValid(newEmail)) {
			if (isEmailNotRepeated(newEmail)) {
				if (isUsernamePresent(username)) {
					valid = true;
				} else {
					throw new UserInvalidException("User not found");
				}
			} else {
				throw new UserRepeatedException("Email ID is already used by a user");
			}
		} else {
			throw new UserInvalidException("Please enter valid email ID");
		}
		return valid;
	}
}
