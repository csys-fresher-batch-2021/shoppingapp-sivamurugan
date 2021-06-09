package in.siva.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.siva.util.DiscountCouponUtil;

public class DiscountRelatedTest {

	@Test
	public void generateCouponTest() {
		String coupon = DiscountCouponUtil.generateCoupon();
		System.out.println(coupon);
		assertEquals(10, coupon.length());
	}
	
	@Test
	public void discountTestOne() {
		int discount = DiscountCouponUtil.findDiscountAmount(999);
		assertEquals(0, discount);
	}

	@Test
	public void discountTestTwo() {
		int discount = DiscountCouponUtil.findDiscountAmount(1000);
		assertEquals(50, discount);
	}
	
	@Test
	public void discountTestThree() {
		int discount = DiscountCouponUtil.findDiscountAmount(1500);
		assertEquals(50, discount);
	}
	
	@Test
	public void discountTestFour() {
		int discount = DiscountCouponUtil.findDiscountAmount(2000);
		assertEquals(150, discount);
	}
	
	@Test
	public void discountTestFive() {
		int discount = DiscountCouponUtil.findDiscountAmount(2500);
		assertEquals(150, discount);
	}
	
	@Test
	public void discountTestSix() {
		int discount = DiscountCouponUtil.findDiscountAmount(3000);
		assertEquals(300, discount);
	}
	
	@Test
	public void discountTestSeven() {
		int discount = DiscountCouponUtil.findDiscountAmount(3500);
		assertEquals(300, discount);
	}
	
	@Test
	public void discountTestEight() {
		int discount = DiscountCouponUtil.findDiscountAmount(4000);
		assertEquals(450, discount);
	}
	
	@Test
	public void discountTestNine() {
		int discount = DiscountCouponUtil.findDiscountAmount(4500);
		assertEquals(450, discount);
	}

	@Test
	public void discountTestTen() {
		int discount = DiscountCouponUtil.findDiscountAmount(5000);
		assertEquals(600, discount);
	}
}
