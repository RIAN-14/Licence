package calendar;

public class Date implements APIDate {
	private int day, month, year;
	public static final int MIN_DAY = 1;
	public static final int MAX_DAY = 31;
	public static final int MIN_MONTH = 1;
	public static final int MAX_MONTH = 12;
	public static final int MIN_YEAR = 1873;
	public static final int DAYS_IN_WEEK = 7;

	public Date(int d, int m, int y)
	throws BadDayException, BadMonthException, BadYearException {
		setDay(d);
		setMonth(m);
		setYear(y);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int value) throws BadDayException {
		if (value < MIN_DAY || value > MAX_DAY) throw new BadDayException();
		day = value;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int value) throws BadMonthException {
		if (value < MIN_MONTH || value > MAX_MONTH) throw new BadMonthException();
		month = value;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int value) throws BadYearException {
		if (value < MIN_YEAR) throw new BadYearException();
		year = value;
	}

	public void oneDayEarlier() {
		try {
			if (getDay() == MIN_DAY) {
				setPreviousMonth();
				setDay(numberOfDaysForMonth(getMonth(), getYear()));
			} else {
				setDay(getDay() - 1);
			}
		} catch (Exception e) { }
	}

	public void oneDayLater() {
		try {
			if (getDay() == numberOfDaysForMonth(getMonth(), getYear())) {
				setNextMonth();
				setDay(MIN_DAY);
			} else {
				setDay(getDay() + 1);
			}
		} catch (Exception e) { }
	}

	private void setNextMonth() {
		try {
			if (getMonth() == MAX_MONTH) {
				setMonth(MIN_MONTH);
				setYear(getYear() + 1);
			} else {
				setMonth(getMonth() + 1);
			}
		} catch (Exception e) { }
	}

	private void setPreviousMonth() {
		try {
			if (getMonth() == MIN_MONTH) {
				setMonth(MAX_MONTH);
				setYear(getYear() - 1);
			} else {
				setMonth(getMonth() - 1);
			}
		} catch (Exception e) { }
	}

	public static int numberOfDaysForMonth(int m, int y) {
		switch(m) {
			case  1:
			case  3:
			case  5:
			case  7:
			case  8:
			case 10:
			case 12: return 31;
			case  4:
			case  6:
			case  9:
			case 11: return 30;
			case  2: return leapYear(y) ? 29 : 28;
			default: return 0;
		}
	}

	public static boolean leapYear(int y) {
		if (y % 400 == 0) {
			return true;
		} else {
			 return (y % 4 == 0) && (y % 100 != 0);
		}
	}

	public void oneWeekEarlier() {
		for(int i = 0; i < DAYS_IN_WEEK; i++) oneDayEarlier();
	}

	public void oneWeekLater() {
		for(int i = 0; i < DAYS_IN_WEEK; i++) oneDayLater();
	}

}
