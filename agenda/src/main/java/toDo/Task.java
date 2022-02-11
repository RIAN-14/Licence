package toDo;

import calendar.BadDayException;
import calendar.BadMonthException;
import calendar.BadYearException;
import calendar.Date;
import calendar.Duration;
import calendar.Time;
import calendar.TooBigHourException;
import calendar.TooBigMinuteException;
import calendar.TooSmallHourException;
import calendar.TooSmallMinuteException;

public class Task {
	private String name;
	private String comment;
	private Date dueDate;
	private Time dueTime;
	private Status status;
	private Duration duration;
	public Task(String taskName) {
		name = taskName;
		comment = "";
		dueDate = null;
		dueTime = null;
		duration = null;
		status = Status.TODO;
	}
	public String toString() {
		String s = name;
		if (dueDate != null) {
			s += " échéance le " + dueDate;
			if (dueTime != null) {
				s += " à " + dueTime;
			}
		}
		if (status == Status.DONE) {
			s += " terminé en " + duration;
		}
		return s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDueDate() {
		return dueDate;
	}
	/*
	public void setDueTo(Date dueDate) { //quand agrégation
		this.dueDate = dueDate;
		this.dueTime = null;
	}
	*/
	public void setDueTo(int day, int month, int year)
	throws BadDayException, BadMonthException, BadYearException
	{ //quand composition
		dueDate = new Date(day, month, year);
		this.dueTime = null;
	}
	/*
	public void setDueTo(Date dueDate, Time dueTime) { //quand agrégation
		this.dueDate = dueDate;
		this.dueTime = dueTime;
	}
	*/
	public void setDueTo(int day, int month, int year, int hour, int minute)
			throws BadDayException, BadMonthException, BadYearException,
				   TooSmallMinuteException, TooBigMinuteException, TooSmallHourException, TooBigHourException
	{ //quand composition
		dueDate = new Date(day, month, year);
		dueTime = new Time(hour, minute);
	}
	public Time getDueTime() {
		return dueTime;
	}
	public Status getStatus() {
		return status;
	}
	public void setInProgress() {
		status = Status.IN_PROGRESS;
	}
	public void setDone(int hours, int minutes)
	throws TooSmallMinuteException, TooBigMinuteException, TooSmallHourException {
		status = Status.DONE;
		duration = new Duration(hours, minutes);
	}
}
