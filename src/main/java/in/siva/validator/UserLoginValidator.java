package in.siva.validator;

import java.util.List;
import in.siva.dao.UserDetailDAO;
import in.siva.exception.DBException;
import in.siva.model.UserDetail;

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
	 * @throws DBException 
	 */
	public static boolean userValidator(String username, String password) throws DBException {

		// Declaration
		boolean valid = false;

		// To get user details
		List<UserDetail> userDetils = UserDetailDAO.getUserDetails();

		// Business Logic
			for (UserDetail user : userDetils) {
				if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
					valid = true;
					break;
				}
			}
		return valid;
	}
}
