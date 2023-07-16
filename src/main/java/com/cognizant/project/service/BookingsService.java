package com.cognizant.project.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.project.dao.ExeQuery;
import com.cognizant.project.model.Bookings;

@Service
public class BookingsService {
	
	@Autowired
	ExeQuery query;

	public List<Bookings> getBookings(String email) throws SQLException{
		return query.getBookings(email);
	}

	public String getSource(String busId) {
		return query.getSource(busId);
	}

	public String getDestination(String busId) {
		return query.getDestination(busId);
	}

	public void deleteBooking(String bookingId) {
		query.deleteBooking(bookingId);
	}

	public void increaseSeats(int busId, String date, int seatsbooked) {
		query.increaseSeats(busId, date, seatsbooked);
	}

	public List<Bookings> getAllBookings() throws SQLException {
		return query.getAllBookings();
	}
}
