package calendar;

public class Duration extends Moment {
	public Duration() {
		hours = 1;
		minutes = MIN_MINUTES;
	}
	
	public Duration(int h, int m)
	throws TooSmallMinuteException, TooBigMinuteException,
	       TooSmallHourException
	{
		setHours(h);
		setMinutes(m);
	}
	
	public String toString() {
		return toString("h");
	}

	public void setHours(int h)
	throws TooSmallHourException {
		if (h < MIN_HOURS) throw new TooSmallHourException(this, h);
		hours = h;
	}

	public void oneHourMore() {
		hours++;
	}

	public void oneHourLess() throws TooSmallDurationException {
		if (hours == MIN_HOURS)
			throw new TooSmallDurationException();
		else
			hours--;
	}

	public void oneMinuteLess() throws TooSmallDurationException {
		if (hours == MIN_HOURS && minutes == MIN_MINUTES)
			throw new TooSmallDurationException();
		minutes--;
		if (minutes < MIN_MINUTES) {
			minutes = MAX_MINUTES;
			oneHourLess();
		}
	}
}

