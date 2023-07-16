package com.cognizant.project.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.project.dao.ExeQuery;
import com.cognizant.project.model.Bus;

@Service
public class BusService {

	@Autowired
	ExeQuery query;

	public List<Bus> BusList(String source, String destination, String date) throws Exception {

		List<Bus> list = query.getBuses(source, destination, date);

		if (list.size() > 0) {
			return list;
		} else {
			throw new Exception("No Buses Found");
		}

	}

	public List<Bus> AllBusList() throws Exception {

		List<Bus> list = query.getAllBuses();

		if (list.size() > 0) {
			return list;
		} else {
			throw new Exception("No Buses Found");
		}

	}

	public int getAvailableSeats(int busId, String date) {
		int availableSeats = -1;

		if (query.getAvailableSeats(busId, date) != -1) {
			availableSeats = query.getAvailableSeats(busId, date);
		}

		return availableSeats;
	}

	public int makeBooking(String busId, String email, String date, int numberOfSeats) throws SQLException {

		String ticketId = findTicketId(busId);
		int cost = findCost(numberOfSeats, busId);

		query.reduceSeats(busId, date, numberOfSeats);
		return query.makeBooking(ticketId, busId, email, date, numberOfSeats, cost);
	}

	public String findTicketId(String busId) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		Date currentDate = new Date();
		String fdate = dateFormat.format(currentDate);

		Random random = new Random();
		int uniqueNumber = random.nextInt(10000);
		String formattedUniqueNumber = String.format("%04d", uniqueNumber);

		String ticketId = busId + fdate + formattedUniqueNumber;
		return ticketId;
	}

	public int findCost(int numberOfSeats, String busId) throws SQLException {
		return query.findPrice(busId) * numberOfSeats;
	}

}
