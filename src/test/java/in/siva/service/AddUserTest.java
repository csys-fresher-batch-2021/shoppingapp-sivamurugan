package in.siva.service;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;
import in.siva.constants.Constants;
import in.siva.exception.DBException;
import in.siva.exception.UserInvalidException;
import in.siva.exception.UserRepeatedException;
import in.siva.model.UserDetail;

public class AddUserTest {

	/**
	 * This test case has all details valid
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void validUserTest() {
		UserDetail user1 = new UserDetail();
		user1.setName("Siva Murugan");
		user1.setAge(21);
		user1.setGender(Constants.MALE);
		user1.setMobileNumber(6369855563L);
		user1.setEmail("sivamurugan5101999@gmail.com");
		user1.setUsername("SivaMurugan");
		user1.setPassword("Sivasys123@");
		user1.setRole(Constants.USER);
		try {
			UserService.addUser(user1);

		} catch (UserInvalidException e) {
			fail();
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid name which is numbers so invalid user details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidNameTest() {
		UserDetail user2 = new UserDetail();
		user2.setName("11111");
		user2.setAge(21);
		user2.setGender(Constants.MALE);
		user2.setMobileNumber(6369850563L);
		user2.setEmail("invalidName@gmail.com");
		user2.setUsername("invalidName");
		user2.setPassword("Sivasys123@");
		user2.setRole(Constants.USER);
		try {
			UserService.addUser(user2);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has negative age so invalid user details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidAgeTest() {
		UserDetail user3 = new UserDetail();
		int age = -8;
		user3.setName("Invalid Age");
		user3.setAge(age);
		user3.setGender(Constants.MALE);
		user3.setMobileNumber(6369750563L);
		user3.setEmail("invalidAge@gmail.com");
		user3.setUsername("invalidAge");
		user3.setPassword("Sivasys123@");
		user3.setRole(Constants.USER);
		try {
			UserService.addUser(user3);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has only 9 digits as mobile number so invalid detailss
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidNumberSizeTest() {
		UserDetail user4 = new UserDetail();
		user4.setName("InvalidNumber");
		user4.setAge(21);
		user4.setGender(Constants.MALE);
		user4.setMobileNumber(63608505L);
		user4.setEmail("invalidNumber@gmail.com");
		user4.setUsername("invalidNumber");
		user4.setPassword("Sivasys123@");
		user4.setRole(Constants.USER);
		try {
			UserService.addUser(user4);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid email format so invalid user details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidEmailNoSpecialCaseTest() {
		UserDetail user5 = new UserDetail();
		user5.setName("InvalidEmail");
		user5.setAge(21);
		user5.setGender(Constants.MALE);
		user5.setMobileNumber(6360050563L);
		user5.setEmail("invalidNoSpecialgmail.com");
		user5.setUsername("invalidEmail1");
		user5.setPassword("Sivasys123@");
		user5.setRole(Constants.USER);
		try {
			UserService.addUser(user5);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid email format so invalid user details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidUsernameTest() {
		UserDetail user6 = new UserDetail();
		user6.setName("Invalid Username");
		user6.setAge(21);
		user6.setGender(Constants.MALE);
		user6.setMobileNumber(636980003L);
		user6.setEmail("invalidUserName@gmail.com");
		user6.setUsername("");
		user6.setPassword("Sivasys123@");
		user6.setRole(Constants.USER);
		try {
			UserService.addUser(user6);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid password format so invalid user details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidPasswordWithoutNumberTest() {
		UserDetail user7 = new UserDetail();
		user7.setName("InvalidPass");
		user7.setAge(21);
		user7.setGender(Constants.MALE);
		user7.setMobileNumber(6369999563L);
		user7.setEmail("invalidpass1@gmail.com");
		user7.setUsername("InvalidPass1");
		user7.setPassword("Sivasys@");
		user7.setRole(Constants.USER);
		try {
			UserService.addUser(user7);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid password format so invalid user details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidPasswordWithoutSpecialCharacterTest() {
		UserDetail user8 = new UserDetail();
		user8.setName("withoutSpecial");
		user8.setAge(21);
		user8.setGender(Constants.MALE);
		user8.setMobileNumber(9999850563L);
		user8.setEmail("invalidpass2@gmail.com");
		user8.setUsername("invalidPass2");
		user8.setPassword("Sivasys123");
		user8.setRole(Constants.USER);
		try {
			UserService.addUser(user8);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case has invalid password details so invalid user details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void invalidPasswordWithoutUpperCaseTest() {
		UserDetail user9 = new UserDetail();
		user9.setName("InvalidPass");
		user9.setAge(21);
		user9.setGender(Constants.MALE);
		user9.setMobileNumber(8329850563L);
		user9.setEmail("invalidpass3@gmail.com");
		user9.setUsername("invalidpass3");
		user9.setPassword("sivasys123@");
		user9.setRole(Constants.USER);
		try {
			UserService.addUser(user9);

		} catch (UserInvalidException e) {
			assertEquals("Invalid User Details", e.getMessage());
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			fail();
		}
	}

	/**
	 * This test case's mobile number is already used so user already registered
	 * exception
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void repeatedMobileNumberTest() {
		UserDetail user10 = new UserDetail();
		user10.setName("RepeatMobile");
		user10.setAge(21);
		user10.setGender(Constants.MALE);
		user10.setMobileNumber(6369855563L);
		user10.setEmail("repeatmobile@gmail.com");
		user10.setUsername("repeatMobile");
		user10.setPassword("Sivasys123@");
		user10.setRole(Constants.USER);
		try {
			UserService.addUser(user10);
			fail();

		} catch (UserRepeatedException e) {
			assertEquals("Sorry! This mobile number is already used by a user. Try another mobile number", e.getMessage());
		} catch (DBException e) {
			fail();
		}
	}

	/**
	 * This test case's email is already used so user already registered exception
	 */
	@Test
	public void repeatedEmailTest() {
		UserDetail user11 = new UserDetail();
		user11.setName("RepeatEmail");
		user11.setAge(21);
		user11.setGender(Constants.MALE);
		user11.setMobileNumber(7729850563L);
		user11.setEmail("sivamurugan5101999@gmail.com");
		user11.setUsername("repeatEmail5");
		user11.setPassword("Sivasys123@");
		user11.setRole(Constants.USER);
		try {
			UserService.addUser(user11);
			fail();
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			assertEquals("Sorry! This email is already used by a user. Try another email", e.getMessage());
		}
	}

	/**
	 * This test case's username is already used so user already registered
	 * exception
	 */
	@Test
	public void repeatedUsernameTest() {
		UserDetail user12 = new UserDetail();
		user12.setName("RepeatUsername");
		user12.setAge(21);
		user12.setGender(Constants.MALE);
		user12.setMobileNumber(8329899563L);
		user12.setEmail("repeatusername@gmail.com");
		user12.setUsername("SivaMurugan");
		user12.setPassword("Sivasys123@");
		user12.setRole(Constants.USER);
		try {
			UserService.addUser(user12);
			fail();
		} catch (DBException e) {
			fail();
		} catch (UserRepeatedException e) {
			assertEquals("Sorry! This username is already used by a user try another username", e.getMessage());
		}
	}

}
