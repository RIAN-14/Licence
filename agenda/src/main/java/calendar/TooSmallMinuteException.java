package calendar;

public class TooSmallMinuteException extends Exception {
	public TooSmallMinuteException(Moment m, int minute) {
		super("Tentative impossible d'affectation de minute à " + m + " avec la valeur " + minute + " trop petite !");
	}
}
