package com.cognizant.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.project.model.Bus;
import com.cognizant.project.service.BusService;

@Controller
public class BusController {
	
	String jdate;
	
	@Autowired
	BusService service;

	@GetMapping("searchbus")
	public String searchbus() {
		return "searchbus";
	}
	
	@PostMapping("searchbus")
	public ModelAndView method1(HttpServletRequest request) {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		jdate = request.getParameter("date");
		System.out.println("date: "+jdate);
		ModelAndView mv = new ModelAndView();

		try {
			List<Bus> list = service.BusList(source, destination, jdate);
			List<Integer> seats = new ArrayList<>();
			for (Bus obj : list) {
				int i = service.getAvailableSeats(obj.getId(), jdate);
				System.out.println(obj.getId());
				seats.add(i);
			}
			System.out.println(seats);
			mv.setViewName("buslist");
			mv.addObject("date", jdate);
			mv.addObject("list", list);
			mv.addObject("seats", seats);
			return mv;
		} catch (Exception e) {

			mv.setViewName("searchbus");
			mv.addObject("message", "No Buses Found");
			return mv;
		}
	}
	
	public String getDate(){
		return jdate;
	}
	

}
