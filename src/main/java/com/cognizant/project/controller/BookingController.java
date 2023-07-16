package com.cognizant.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.project.model.Schedule;
import com.cognizant.project.service.BusService;

@Controller
public class BookingController {
	
	Schedule schedule;
	
	@Autowired
	BusController busController;
	
	@Autowired
	BusService service;
	
	@GetMapping("buslist")
	public String getbuslist() {
		return "buslist";
	}

	@PostMapping("buslist")
	public void buslist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String busId = request.getParameter("busId");
		int numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		System.out.println(email);
		String date = busController.getDate();
		
		int res = service.makeBooking(busId, email, date, numberOfSeats);
		
		if(res>0) {
			response.sendRedirect("searchbus");
		}
	}
}
