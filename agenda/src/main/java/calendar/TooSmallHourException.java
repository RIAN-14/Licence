package calendar;

public class TooSmallHourException extends Exception {
	public TooSmallHourException(Moment m, int h) {
		super("Tentative impossible d'affectation des heures à " + m + " avec la valeur " + h + " trop petite !");
	}
}
