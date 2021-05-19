package in.siva.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import in.siva.exception.UserInvalidException;

public class UpdateNameTest {

	/**
	 * This test case's username is present in db so it will update the user's name
	 */
	@Test
	public void validNameUpdateTest() {
		String newName = "Karan Kannan"; // Old name = 'Karan'
		String username = "Karan";
		try {
			UserService.updateName(newName, username);
		} catch (ClassNotFoundException | SQLException e) {
			fail();
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This test case's username is not present in db so it will return user not found message
	 */
	@Test
	public void invalidUsernameUpdateNameTest() {
		String newName = "HELLO"; 
		String username = "Hello";
		try {
			UserService.updateName(newName, username);
		} catch (ClassNotFoundException | SQLException e) {
			fail();
			e.printStackTrace();
		} catch(UserInvalidException e) {
			assertEquals("User not found", e.getMessage());
		}
		
	}

}
