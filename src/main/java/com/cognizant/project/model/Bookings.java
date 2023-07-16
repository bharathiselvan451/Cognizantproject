package com.cognizant.project.model;

public class Bookings {

	private int bookingId;
	private String ticketId;
	private String busId;
	private String email;
	private String date;
	private int seatsbooked;
	private int cost;
	
	public Bookings(int bookingId, String ticketId, String busId, String email,  String date, int seatsbooked,
			int cost) {
		super();
		this.bookingId = bookingId;
		this.ticketId = ticketId;
		this.email = email;
		this.busId = busId;
		this.date = date;
		this.seatsbooked = seatsbooked;
		this.cost = cost;
	}

	public Bookings(int bookingId, String ticketId, String busId, String date, int seatsbooked, int cost) {
		super();
		this.bookingId = bookingId;
		this.ticketId = ticketId;
		this.busId = busId;
		this.date = date;
		this.seatsbooked = seatsbooked;
		this.cost = cost;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSeatsbooked() {
		return seatsbooked;
	}
	public void setSeatsbooked(int seatsbooked) {
		this.seatsbooked = seatsbooked;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
}
