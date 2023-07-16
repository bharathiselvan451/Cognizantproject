package com.cognizant.project.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.project.model.Bookings;
import com.cognizant.project.service.BookingsService;

@Controller
public class MyBookingsController {
	
	@Autowired
	BookingsService service;

	@GetMapping("mybookings")
	public ModelAndView getBookings(HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		String email = (String)session.getAttribute("email");
		System.out.println(email);
		List<Bookings> bookingsList = service.getBookings(email);
		List<String> sourceList = new ArrayList<>();
		List<String> destinationList = new ArrayList<>();
		
		for(Bookings booking: bookingsList) {
			String source = service.getSource(booking.getBusId());
			String destination = service.getDestination(booking.getBusId());
			sourceList.add(source);
			destinationList.add(destination);
		}
		
		mv.addObject("destinationList", destinationList);
		mv.addObject("sourceList", sourceList);
		mv.addObject("bookingsList", bookingsList);
		mv.setViewName("mybookings");
		
		return mv;
	}
	
	@PostMapping("deletebooking")
	public String postBookings(@RequestParam("bookingId") String bookingId, 
			@RequestParam("seatsBooked") int seatsbooked, @RequestParam("date") String date,
			@RequestParam("busId") int busId,Model m) {
		
		DateTimeFormatter format  = DateTimeFormatter.ofPattern("yyyy-MM-d");
		LocalDate date_x = LocalDate.parse(date, format);
		if(date_x.compareTo(java.time.LocalDate.now())>=0) {
			service.increaseSeats(busId, date, seatsbooked);
			service.deleteBooking(bookingId);
			return "redirect:/mybookings";
		}
		else {
			m.addAttribute("Message", "Your cancellation time has passed");
			return "redirect:/mybookings";
		}
		
	}
}
