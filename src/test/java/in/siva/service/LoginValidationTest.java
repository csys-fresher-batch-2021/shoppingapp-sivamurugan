package in.siva.service;

import static org.junit.Assert.*;
import org.junit.Test;

import in.siva.constants.Constants;
import in.siva.exception.InvalidLoginException;
import in.siva.model.UserDetail;

public class LoginValidationTest {

	/**
	 * Static used to add one valid user
	 */
	static {
<<<<<<< HEAD
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6369855563l, "siva@gmail.com", "siva123",
=======
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 8355676589l, "siva12343523@gmail.com", "hihihi",
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
				"Sivasys123@", Constants.USER);
		UserService.addUser(user);
	}

	/**
	 * This test case has valid user login details
	 */
	@Test
	public void validUserLoginTest() {
		try {
<<<<<<< HEAD
			String infoMessage = UserService.loginValidation("siva123", "Sivasys123@", Constants.USER);
			assertEquals("User Login Sucessful", infoMessage);
=======
			String infoMessage = UserService.loginValidation("hihihi", "Sivasys123@", Constants.USER);
			assertEquals("User Login Successful", infoMessage);
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
		} catch (InvalidLoginException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid username so invalid login credentials
	 */
	@Test
	public void invalidUsernameLoginTest() {
		try {
			String infoMessage = UserService.loginValidation("siva1234", "Sivasys123@", Constants.USER);
		} catch (InvalidLoginException e) {
			assertEquals("Invalid Login Credentials! Try Again", e.getMessage());
		}
	}

	/**
	 * This test case has invalid password so invalid login credentials
	 */
	@Test
	public void invalidPasswordLoginTest() {
		try {
<<<<<<< HEAD
			String infoMessage = UserService.loginValidation("siva123", "Sivasys12@", Constants.USER);
=======
			String infoMessage = UserService.loginValidation("hihihi", "Sivasys12@", Constants.USER);
>>>>>>> 5e0491d445a6d22ad4315f3db51cb6d6486afab1
		} catch (InvalidLoginException e) {
			assertEquals("Invalid Login Credentials! Try Again", e.getMessage());
		}
	}

	/**
	 * This test case has valid admin details so admin login successful
	 */
	@Test
	public void validAdminLoginTest() {
		try {
			String infoMessage = UserService.loginValidation("admin", "Admin123@", Constants.ADMIN);
			assertEquals("Admin Login Successful", infoMessage);
		} catch (InvalidLoginException e) {
			fail();
		}
	}

	/**
	 * This test case invalid admin login details so login invalid
	 * 
	 */
	@Test
	public void invalidAdminLoginTest() {
		try {
			String infoMessage = UserService.loginValidation("adm", "admin123@", Constants.ADMIN);
		} catch (InvalidLoginException e) {
			assertEquals("Invalid Login Credentials! Try Again", e.getMessage());
		}
	}

}
