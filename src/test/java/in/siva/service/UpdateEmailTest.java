package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;

public class UpdateEmailTest {

	/**
	 * This method has valid email details so details added in DB
	 */
	@Test
	public void validEmailUpdateTest() {
		String newEmail = "kannankaran98@gmail.com"; 
		String username = "Karan";
		try {
			UserService.updateEmail(newEmail, username);
		} catch (DBException e) {
			fail();
		}

	}
	
	/**
	 * This test case has invalid username so user not found message is returned
	 */
	@Test
	public void invalidEmailUpdateTest() {
		String newEmail = "kannankaran9@gmail.com"; 
		String username = "Invalid";
		try {
			UserService.updateEmail(newEmail, username);
		} catch (DBException e) {
			fail();
		} catch(UserInvalidException | UserRepeatedException e) {
			assertEquals("User not found", e.getMessage());
		}

	}
	
	/**
	 * This test case didn't has @ in email so invalid email message
	 */
	@Test
	public void invalidEmailIdTest() {
		String newEmail = "karan96gmail.com"; 
		String username = "Karan";
		try {
			UserService.updateEmail(newEmail, username);
		} catch (DBException e) {
			fail();
		} catch(UserInvalidException | UserRepeatedException e) {
			assertEquals("Please enter valid email ID", e.getMessage());
		} 

	}
	
	/**
	 * This email is already used by a user so email already used exception
	 */
	@Test
	public void alreadyUsedEmailTest() {
		String newEmail = "kannankaran@gmail.com"; 
		String username = "Karan";
		try {
			UserService.updateEmail(newEmail, username);
		} catch (DBException e) {
			fail();
		} catch(UserInvalidException | UserRepeatedException e) {
			assertEquals("Email ID is already used by a user", e.getMessage());
		} 

	}
}
