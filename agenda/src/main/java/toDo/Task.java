package toDo;

import calendar.Date;
import calendar.Duration;
import calendar.Time;

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
	
	public void complete(int hours, int minutes) {
		status = Status.DONE;
		duration = new Duration(hours,minutes);
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

	public void setDueTo(int minute, int hour) {
		this.dueTime = new Time(minute,hour);
	}
	
	public void setDueTo(int day, int month, int year) {
		this.dueDate = new Date(day, month, year);
	}
	
	public void setDueTo(int minute, int hour, int day, int month, int year) {
		this.dueDate = new Date(day, month, year);
		this.dueTime = new Time(minute,hour);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
