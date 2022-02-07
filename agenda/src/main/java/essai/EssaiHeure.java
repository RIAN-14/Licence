package essai;

import calendar.Time;
import calendar.TooBigHourException;
import calendar.TooBigMinuteException;
import calendar.TooSmallHourException;
import calendar.TooSmallMinuteException;

class EssaiHeure {
	public static void main(String args[])
	throws TooBigMinuteException, TooSmallMinuteException
	{
		try {
			Time t;
			t = new Time(15, 52);
			System.out.println("t = " + t.getHours() + ":" + t.getMinutes());
			t.setHours(50);
			System.out.println("t = " + t);
//    		t.minute += 30; //interdit et impossible car hour et minute sont private
			t.setMinutes(t.getMinutes() + 30);
			System.out.println("t = " + t.getHours() + ":" + t.getMinutes());
		} catch (TooBigHourException e1) {
			System.err.println(e1);
		} catch (TooSmallHourException e2) {
			System.err.println(e2);
		}
	}
}
