package in.siva.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.siva.constants.Constants;
import in.siva.exception.InvalidLoginException;

public class LoginValidationTest {

	/**
	 * This test case has valid user login details
	 */
	@Test
	public void validUserLoginTest() {
		try {
			String infoMessage = UserService.loginValidation("SivaMurugan", "Sivasys123@", Constants.USER);
			assertEquals("User Login Successful", infoMessage);
		} catch (InvalidLoginException e) {
			fail();
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
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
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
		}
	}

	/**
	 * This test case has invalid password so invalid login credentials
	 */
	@Test
	public void invalidPasswordLoginTest() {
		try {
			String infoMessage = UserService.loginValidation("hihihi", "Sivasys12@", Constants.USER);
		} catch (InvalidLoginException e) {
			assertEquals("Invalid Login Credentials! Try Again", e.getMessage());
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
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
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
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
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
		}
	}

}
