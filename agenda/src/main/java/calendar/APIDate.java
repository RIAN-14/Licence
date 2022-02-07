package calendar;

interface APIDate {
	String toString();
	int getDay();
	void setDay(int value) throws BadDayException;
	int getMonth();
	void setMonth(int value) throws BadMonthException;
	int getYear();
	void setYear(int value) throws BadYearException;
	void oneDayEarlier();
	void oneDayLater();
	void oneWeekEarlier();
	void oneWeekLater();
}
