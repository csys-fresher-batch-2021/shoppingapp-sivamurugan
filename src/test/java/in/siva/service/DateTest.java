package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.util.DateTimeUtil;

public class DateTest {

	@Test
	public void previousDateTest() {
		String previousDateTime = DateTimeUtil.getPreviousDate();
		System.out.println(previousDateTime);
		assertEquals("2021-06-07 14:43:50", previousDateTime);
	}
	
	@Test
	public void currentDateTest() {
		String currentDateTest = DateTimeUtil.getPreviousDate();
		System.out.println(currentDateTest);
		assertEquals("2021-06-08 14:43:50", currentDateTest);
	}
	
	@Test
	public void ExipryDateTest() {
		String expiryDate = DateTimeUtil.getExpiryDate();
		System.out.println(expiryDate);
		assertEquals("2021-08-07 14:43:50", expiryDate);
	}

}
