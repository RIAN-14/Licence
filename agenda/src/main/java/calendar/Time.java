package calendar;

public class Time extends Moment {
	public Time() {
		try {
			setHours(12);
			setMinutes(0);
		} catch (TooSmallHourException e) {
		} catch (TooBigHourException e) {
		} catch (TooSmallMinuteException e) {
		} catch (TooBigMinuteException e) {
		}
	}
	
	public Time(int h, int m)
	throws TooSmallMinuteException, TooBigMinuteException,
	       TooSmallHourException, TooBigHourException {
		setHours(h);
		setMinutes(m);
	}
	
	public String toString() {
		String txt = (hours < 10) ? "0" : "";
		return txt + toString(":");
	}

	public void setHours(int h)
	throws TooSmallHourException, TooBigHourException {
		if (h > MAX_HOURS) throw new TooBigHourException(this, h);
		if (h < MIN_HOURS) throw new TooSmallHourException(this, h);
		hours = h;
	}

	public void oneHourMore() {
		if (hours < MAX_HOURS)
			hours++;
		else
			hours = 0;
	}
	
	public void oneHourLess() {
		hours--;
		if (hours < MIN_HOURS)
			hours = MAX_HOURS;
	}

	public void oneMinuteLess() {
		minutes--;
		if (minutes < MIN_MINUTES) {
			minutes = MAX_MINUTES;
			oneHourLess();
		}
	}

}
