package com.cognizant.project.model;

import java.util.Date;

public class Schedule {

	private int scheduleId;
	private int busId;
	private Date date;
	private int seats;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public Schedule() {
		new Schedule();
	}
	
	public Schedule(int busId, Date date, int seats) {
		super();
		this.busId = busId;
		this.date = date;
		this.seats = seats;
	}
	
	
	
	
}
