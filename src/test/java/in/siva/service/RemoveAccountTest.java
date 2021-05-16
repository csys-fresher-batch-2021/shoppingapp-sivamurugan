package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.constants.Constants;
import in.siva.exception.UserInvalidException;
import in.siva.model.UserDetail;

public class RemoveAccountTest {

	static {
		UserDetail user = new UserDetail("Bala Krishnan", 48, Constants.MALE, 9789546789l, "bala@gmail.com", "bala",
				"Sivasys123@", Constants.USER);
		UserService.addUser(user);
	}
	
	@Test
	public void invalidUsernameTest() {
		try {
			UserService.removeAccount("rakas");
		} catch(UserInvalidException e) {
			assertEquals("User not found", e.getMessage());
		}
	}
	
	@Test
	public void validUsernameTest() {
		try {
			UserService.removeAccount("bala");
		} catch(UserInvalidException e) {
			fail();
		}
	}

}
