package in.siva.validator;

import java.util.List;
import in.siva.dao.UserDetailDao;
import in.siva.exception.DBException;
import in.siva.model.UserDetail;
public class UserValidator {

	
	private UserValidator() {
		// Default constructor
	}
	
	/**
	 * This method is used to validate whether the details entered by user is valid or not
	 * It will validate all details and if all details are valid it will return true else it will return false
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
	 * This method is used to check whether the sensitive details entered by user is already registered by a user or not
	 * If not used by it will return true
	 * Else it will return false
	 * @param user
	 * @return
	 * @throws DBException 
	 */
	public static boolean isUserNotRepeated(UserDetail user) throws DBException{
		// Declaration
		boolean valid = true;
		// To get user details
		List<UserDetail> userDetails = UserDetailDao.getUserDetails();
		// Business Logic
		for (UserDetail userDetail : userDetails) {
			if (user.getEmail().equalsIgnoreCase(userDetail.getEmail()) || userDetail.getMobileNumber() == user.getMobileNumber()
					|| user.getUsername().equals(userDetail.getUsername())) {
				valid = false;
				break;
			}

		}
		return valid;

	}
	
	/**
	 * This method is used  to check whether the username is present in database or not
	 * If present - true
	 * if not present - false
	 * @param username
	 * @return
	 * @throws DBException 
	 */
	public static boolean isUsernamePresent(String username) throws DBException {
		boolean exists = false;
		List<UserDetail> userDetails = UserDetailDao.getUserDetails();
		for (UserDetail user : userDetails) {
			if(user.getUsername().equals(username)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	/**
	 * This method is used to check whether the entered username & new name is valid or not
	 * Returns true if valid else returns false
	 * @param newName
	 * @param username
	 * @return
	 * @throws DBException 
	 */
	public static boolean isUpdateNameValid(String newName, String username) throws DBException{
		boolean valid = false;
		if(UtilValidator.isStringValid(newName) && isUsernamePresent(username)) {
			valid = true;
		}
		
		return valid;
	}
}

