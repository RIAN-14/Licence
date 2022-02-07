package calendar;

public class TooBigHourException extends Exception {
	public TooBigHourException(Moment m, int h) {
		super("Tentative impossible d'affectation des heures à " + m + " avec la valeur " + h + " trop grande !");
	}
}
