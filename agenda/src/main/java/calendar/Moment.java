package calendar;

public abstract class Moment {
	public static final int MIN_HOURS = 0;
	public static final int MAX_HOURS = 23;
	public static final int MIN_MINUTES = 0;
	public static final int MAX_MINUTES = 59;
	
	protected int hours;
	protected int minutes;

	public Moment() { }

	protected String toString(String delim) {
		String txt = "";
		txt += hours;
		txt += delim;
		if (minutes < 10) txt += "0";
		txt += minutes;
		return txt;
	}

	public int getHours() {
		return hours;
	}

	public abstract void setHours(int h) throws Exception;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int m) throws TooSmallMinuteException, TooBigMinuteException {
		if (m < MIN_MINUTES) throw new TooSmallMinuteException(this, m);
		if (m > MAX_MINUTES) throw new TooBigMinuteException(this, m);
		minutes = m;
	}

	public abstract void oneHourMore();

	public abstract void oneHourLess() throws Exception;

	public void oneMinuteMore() {
		if (minutes < MAX_MINUTES)
			minutes++;
		else {
			minutes = 0;
			oneHourMore();
		}
	}

	public abstract void oneMinuteLess() throws Exception;
}