package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.hotel.Date;

public class DateTest {
	
	private Date d1, d2;

	@Before
	public void setUp() throws Exception {
		d1=new Date();
	}

	@Test
	public void testDate() {
		// Check d1’s day is 0
		assertEquals(d1.getDay(), 0);
		// Check d1’s month is 0, if it is not display appropriate message
		assertEquals("Month should be 0", d1.getMonth(), 0);
		// Check d1’s year is 5, if it is not display appropriate message
		// NOTE : This should fail!
		assertEquals("Year should be 0", d1.getYear(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDateIntIntInt() {
		d2 = new Date(31,12,2017);
	}

	@Test
	public void testSetDay() {
		d1.setDay(21);
		assertEquals(d1.getDay(), 21);
	}

	@Test
	public void testSetMonth() {
		d1.setMonth(11);
		assertEquals(d1.getMonth(), 11);
	}

	@Test
	public void testSetYear() {
		d1.setYear(2017);
		assertEquals(d1.getYear(), 2017);
	}

}
