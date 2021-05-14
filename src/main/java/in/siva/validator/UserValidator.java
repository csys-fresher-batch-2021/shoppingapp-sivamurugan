package in.siva.validator;

import java.util.List;
import in.siva.model.UserDetail;
import in.siva.service.UserService;

public class UserValidator {

	
	private UserValidator() {
		// Default constructor
	}
	
	
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

	public static boolean isUserNotRepeated(UserDetail user) {
		// Declaration
		boolean valid = true;
		// To get user details
		List<UserDetail> userDetails = UserService.getUserDetails();
		// Business Logic
		for (UserDetail userDetail : userDetails) {
			if (user.getEmail().equals(userDetail.getEmail()) || userDetail.getMobileNumber() == user.getMobileNumber()
					|| user.getUsername().equals(userDetail.getUsername())) {
				valid = false;
				break;
			}

		}
		return valid;

	}
}
