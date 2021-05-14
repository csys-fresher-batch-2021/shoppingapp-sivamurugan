package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;
import in.siva.constants.Constants;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;
import in.siva.model.UserDetail;

public class AddUserTest {

	/**
	 * This test case has all details valid
	 */
	@Test
	public void validUserTest() {
		UserDetail user = new UserDetail("SivaMurugan", 21, Constants.MALE, 6369855563L, "siva51900@gmail.com",
				"sivamurugan1", "Sivasys123@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			fail();
		}
	}
	
	/**
	 * This test case has invalid name which is numbers so invalid user details
	 */
	@Test
	public void invalidNameTest() {
		UserDetail user = new UserDetail("1234", 21, Constants.MALE, 6789854567L, "siva5190@gmail.com",
				"sivamuruga1", "Sivasys123@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case has negative age so invalid user details
	 */
	@Test
	public void invalidAgeTest() {
		UserDetail user = new UserDetail("Siva", -9, Constants.MALE, 6889854567L, "hello@gmail.com",
				"hello", "Sivasys123@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case has only 9 digits as mobile number so invalid detailss
	 */
	@Test
	public void invalidNumberSizeTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 688985456L, "hello1@gmail.com",
				"hello1", "Sivasys123@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case has invalid email format so invalid user details
	 */
	@Test
	public void invalidEmailNoSpecialCaseTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6889854562L, "hello2gmailcom",
				"hello2", "Sivasys123@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case has invalid email format so invalid user details
	 */
	@Test
	public void invalidUsernameTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6889854562L, "hello23@gmail.com",
				"12331", "Sivasys123@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case has invalid password format so invalid user details
	 */
	@Test
	public void invalidPasswordWithoutNumberTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6889859562L, "hello234@gmail.com",
				"siva123", "Sivasys@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case has invalid password format so invalid user details
	 */
	@Test
	public void invalidPasswordWithoutSpecialCharacterTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6880859562L, "he1llo234@gmail.com",
				"siva1236", "Sivasys12", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case has invalid password details so invalid user details
	 */
	@Test
	public void invalidPasswordWithoutUpperCaseTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6889859502L, "hello2346@gmail.com",
				"siva123a", "sivasys12@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		}
	}
	
	/**
	 * This test case's mobile number is already used so user already registered exception
	 */
	@Test
	public void repeatedMobileNumberTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6889859502L, "hello2340@gmail.com",
				"hellolo123", "Sivasys12@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserRepeatedException e) {
			assertEquals("Sorry! Some details you entered were already registered by a user", e.getMessage());
		}
	}
	
	
	/**
	 * This test case's email is already used so user already registered exception
	 */
	@Test
	public void repeatedEmailTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 6889859512L, "hello2340@gmail.com",
				"hellolo1234", "Sivasys12@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserRepeatedException e) {
			assertEquals("Sorry! Some details you entered were already registered by a user", e.getMessage());
		}
	}
	
	
	/**
	 * This test case's username is already used so user already registered exception
	 */
	@Test
	public void repeatedUsernameTest() {
		UserDetail user = new UserDetail("Siva", 21, Constants.MALE, 9989859512L, "kyare123@gmail.com",
				"hellolo12345", "Sivasys12@", Constants.ADMIN);
		try {
			UserService.addUser(user);
			
		} catch (UserRepeatedException e) {
			assertEquals("Sorry! Some details you entered were already registered by a user", e.getMessage());
		}
	}

}
