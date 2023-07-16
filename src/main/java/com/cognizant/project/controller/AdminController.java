package com.cognizant.project.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.project.model.Bookings;
import com.cognizant.project.model.Bus;
import com.cognizant.project.model.User;
import com.cognizant.project.service.AdminService;
import com.cognizant.project.service.BookingsService;
import com.cognizant.project.service.BusService;
import com.cognizant.project.service.ProfileService;

@Controller
public class AdminController {
	
	
	@Autowired
	AdminService service;
	
	@Autowired
	BookingsService bookservice;

	@Autowired
	ProfileService profileservice;
	
	@Autowired
	BusService busservice;
	


	@GetMapping("allbookings")
	public ModelAndView getUserBookings() throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Bookings> bookingsList = bookservice.getAllBookings();
		mv.addObject("bookingsList", bookingsList);
		mv.setViewName("allbookings");
		
		return mv;
	}
	
	@PostMapping("deleteuserbooking")
	public String postBookings(@RequestParam("bookingId") String bookingId, 
			@RequestParam("seatsBooked") int seatsbooked, @RequestParam("date") String date,
			@RequestParam("busId") int busId) {
		bookservice.increaseSeats(busId, date, seatsbooked);
		bookservice.deleteBooking(bookingId);
		return "redirect:/allbookings";
	}
	
	@GetMapping("/home")
	public String homepage() {
		return "home";
	}

	@GetMapping("/admin-login")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@GetMapping("/admin-dashboard")
	public String getadminDashboard() {
		return "admindashboard";
	}
	
	@PostMapping("/admin-dashboard")
	public String afterLogin(HttpServletRequest request) {

		String adminName = request.getParameter("adminname");
		String password = request.getParameter("password");
		if (adminName.equals("admin") && password.equals("admin123")) {
			try {
				List<Bus> userList = busservice.AllBusList();
				request.setAttribute("userList", userList);
			}
			catch(Exception e) {
				System.out.println("No buses available- not going to happen in most of the cases");
			}
			
			return "admindashboard";
		} else {
	        request.setAttribute("errorMessage", "Invalid username or password");
			return "adminLogin";
		}
	}
	
	@GetMapping("addbus")
	public String getAddBus() {
		return "addbus";
	}
	
	@GetMapping("addschedule")
	public String getSchedule() {
		return "addschedule";
	}
	
	@PostMapping("addbus")
	public String addBus(@RequestParam("busname") String busname,@RequestParam("source") String source,@RequestParam("destination") String destination,@RequestParam("price") int price) {
		System.out.println(busname+"  "+source+"  "+destination+"  "+price);
		service.addBus(busname, source, destination, price);
		
		return "addbus";
	}
	
	@PostMapping("addschedule")
	public String addBusSchedule(@RequestParam("Bus_Id") int bus_id,
			@RequestParam("date") Date source,
			@RequestParam("seats") int seats,HttpServletRequest request) {
		
		service.addSchedule(bus_id, source, seats);
		return "addschedule";
	}
	
	@GetMapping("userprofile")
	public String getUserProfile(HttpServletRequest request, 
			@RequestParam("name") String name) {

		User user= service.getUserBasedOnName(name);
		request.setAttribute("user", user);
		return "userprofile";
	}
	
}
