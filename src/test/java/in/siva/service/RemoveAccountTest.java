package in.siva.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.siva.constants.Constants;
import in.siva.exception.UserInvalidException;
import in.siva.model.UserDetail;

public class RemoveAccountTest {

	/**
	 * This method is used to add user initially 
	 */
	static {
		UserDetail user = new UserDetail("Bala Krishnan", 48, Constants.MALE, 9789546789l, "bala@gmail.com", "bala",
				"Sivasys123@", Constants.USER);
		try {
			UserService.addUser(user);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method has invalid username (Not present in database) So user not found returned
	 */
	@Test
	public void invalidUsernameTest() {
		try {
			UserService.removeAccount("rakas");
		} catch(UserInvalidException e) {
			assertEquals("User not found", e.getMessage());
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
		}
	}
	
	/**
	 * This method has valid username (present in db) So user removed
	 */
	@Test
	public void validUsernameTest() {
		try {
			UserService.removeAccount("bala");
		} catch(UserInvalidException e) {
			fail();
		} catch (ClassNotFoundException e) {
			fail();
			e.printStackTrace();
		} catch (SQLException e) {
			fail();
			e.printStackTrace();
		}
	}

}
