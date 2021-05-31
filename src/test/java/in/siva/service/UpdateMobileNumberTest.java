package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;

public class UpdateMobileNumberTest {
	/**
	 * This test case's username is present in db so it will update the user's
	 * mobile number
	 * @throws UserRepeatedException 
	 */
	@Test
	public void validMobileNumberUpdateTest() throws UserRepeatedException {
		long newMobile = 8765789876L; 
		String username = "Karan";
		try {
			UserService.updateMobileNumber(newMobile, username);
		} catch (DBException e) {
			fail();
		}

	}
	
	/**
	 * This test case has invalid username so user not found message is returned
	 */
	@Test
	public void invalidMobileNumberUpdateTest() {
		long newMobile = 8989898989L; 
		String username = "Invalid";
		try {
			UserService.updateMobileNumber(newMobile, username);
		} catch (DBException e) {
			fail();
		} catch(UserInvalidException e) {
			assertEquals("User not found", e.getMessage());
		}

	}
	
	/**
	 * This test case has only 9 digits as number so invalid mobile number message
	 * @throws UserRepeatedException 
	 */
	@Test
	public void invalidMobileLengthTest() throws UserRepeatedException {
		long newMobile = 876578987L; 
		String username = "Karan";
		try {
			UserService.updateMobileNumber(newMobile, username);
		} catch (DBException e) {
			fail();
		} catch(UserInvalidException e) {
			assertEquals("Please enter valid mobile number", e.getMessage());
		} 

	}
	
	/**
	 * This mobile number is already used by a user so Mobile number already used exception
	 */
	@Test
	public void alreadyUsedMobileTest() {
		long newMobile = 9999999999L; 
		String username = "Karan";
		try {
			UserService.updateMobileNumber(newMobile, username);
		} catch (DBException e) {
			fail();
		} catch(UserRepeatedException e) {
			assertEquals("Mobile Number is already used by a user", e.getMessage());
		} 

	}

}
