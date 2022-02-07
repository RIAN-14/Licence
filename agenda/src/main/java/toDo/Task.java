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
		this.name = taskName;
		this.status = Status.TODO;
		this.dueDate = null;
		this.dueTime = null;
		this.duration = null;
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

	public Time getDueTime() {
		return dueTime;
	}

	public void setDueTo(int minute, int hour) throws TooSmallMinuteException, TooBigMinuteException, TooSmallHourException, TooBigHourException {
		this.dueTime = new Time(minute,hour);
	}
	
	public void setDueTo(int day, int month, int year) throws BadDayException, BadMonthException, BadYearException {
		this.dueDate = new Date(day, month, year);
	}
	
	public void setDueTo(int minute, int hour, int day, int month, int year) throws BadDayException, BadMonthException, BadYearException, TooSmallMinuteException, TooBigMinuteException, TooSmallHourException, TooBigHourException {
		this.dueDate = new Date(day, month, year);
		this.dueTime = new Time(minute,hour);
	}

	public Status getStatus() {
		return status;
	}
	
	public void setInProgress() {
		status = Status.IN_PROGRESS;
	}
	
	public void complete(int hours, int minutes) throws TooSmallMinuteException, TooBigMinuteException, TooSmallHourException {
		status = Status.DONE;
		duration = new Duration(hours,minutes);
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", comment=" + comment + ", dueDate=" + dueDate + ", dueTime=" + dueTime
				+ ", status=" + status + ", duration=" + duration + "]";
	}
}
