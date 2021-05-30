package in.siva.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.siva.constants.Constants;
import in.siva.exception.DBException;
import in.siva.exception.InvalidLoginException;

public class LoginValidationTest {

	/**
	 * This test case has valid user login details
	 */
	@Test
	public void validUserLoginTest() {
		try {
			String role = UserService.loginValidation("Karan", "Karan123@");
			assertEquals("U", role);
		} catch (InvalidLoginException e) {
			fail();
		} catch (DBException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid username so invalid login credentials
	 */
	@Test
	public void invalidUsernameLoginTest() {
		try {
			String infoMessage = UserService.loginValidation("siva1234", "Sivasys123@");
		} catch (InvalidLoginException e) {
			assertEquals("Invalid Login Credentials! Try Again", e.getMessage());
		} catch (DBException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid password so invalid login credentials
	 */
	@Test
	public void invalidPasswordLoginTest() {
		try {
			String infoMessage = UserService.loginValidation("hihihi", "Sivasys12@");
		} catch (InvalidLoginException e) {
			assertEquals("Invalid Login Credentials! Try Again", e.getMessage());
		} catch (DBException e) {
			fail();
		}
	}

	/**
	 * This test case has valid admin details so admin login successful
	 */
	@Test
	public void validAdminLoginTest() {
		try {
			String role = UserService.loginValidation("Admin2", "Admin123@");
			assertEquals("A", role);
		} catch (InvalidLoginException e) {
			fail();
		} catch (DBException e) {
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
			String role = UserService.loginValidation("adm", "admin123@");
		} catch (InvalidLoginException e) {
			assertEquals("Invalid Login Credentials! Try Again", e.getMessage());
		} catch (DBException e) {
			fail();
		}
	}

}
