package calendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTime {

	@Test
	public void testConstructor()
	throws TooSmallMinuteException, TooBigMinuteException,
	       TooSmallHourException, TooBigHourException {
		Time t;
		t = new Time();
		assertEquals(12, t.getHours());
		assertEquals(0, t.getMinutes());
		t = new Time(17, 30);
		assertEquals(17, t.getHours());
		assertEquals(30, t.getMinutes());
	}

	@Test
	public void testSetters()
	throws TooSmallMinuteException, TooBigMinuteException,
	       TooSmallHourException, TooBigHourException
	{
		Time t;
		t = new Time(9, 50);
		t.setHours(14);
		assertEquals(14, t.getHours());
		t.setMinutes(12);
		assertEquals(12, t.getMinutes());
	}
	
	@Test
	public void testOneHourMore()
	throws TooSmallHourException, TooBigHourException
	{
		Time t;
		t = new Time();
		t.oneHourMore();
		assertEquals(13, t.getHours());
		t.setHours(23);
		t.oneHourMore();
		assertEquals(0, t.getHours());
	}

	@Test
	public void testOneHourLess()
	throws TooSmallHourException, TooBigHourException {
		Time t;
		t = new Time();
		t.oneHourLess();
		assertEquals(11, t.getHours());
		t.setHours(0);
		t.oneHourLess();
		assertEquals(23, t.getHours());
	}
	
	@Test
	public void testOneMinuteMore()
	throws TooSmallMinuteException, TooBigMinuteException
	{
		Time t;
		t = new Time();
		t.oneMinuteMore();
		assertEquals(12, t.getHours());
		assertEquals(1, t.getMinutes());
		t.setMinutes(59);
		t.oneMinuteMore();
		assertEquals(13, t.getHours());
		assertEquals(0, t.getMinutes());
	}

	@Test
	public void testOneMinuteLess()
	throws TooSmallMinuteException, TooBigMinuteException {
		Time t;
		t = new Time();
		t.oneMinuteLess();
		assertEquals(11, t.getHours());
		assertEquals(59, t.getMinutes());
		t.setMinutes(35);
		t.oneMinuteLess();
		assertEquals(11, t.getHours());
		assertEquals(34, t.getMinutes());
	}

}
