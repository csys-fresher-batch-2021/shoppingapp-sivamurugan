package in.siva.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.siva.constants.Constants;
import in.siva.exception.DBException;
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
		} catch (DBException e) {
			fail();
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
		} catch (DBException e) {
			fail();
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
		} catch (DBException e) {
			fail();
		}
	}

}
