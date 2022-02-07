package calendar;

public class TooBigMinuteException extends Exception {
	public TooBigMinuteException(Moment m, int minute) {
		super("Tentative impossible d'affectation de minute � " + m + " avec la valeur " + minute + " trop grande !");
	}
}
