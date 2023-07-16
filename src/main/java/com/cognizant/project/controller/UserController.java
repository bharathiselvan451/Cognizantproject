package com.cognizant.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.project.model.Bus;
import com.cognizant.project.model.User;
import com.cognizant.project.service.BusService;
import com.cognizant.project.service.UserService;

@Controller
public class UserController {
	
	private List<Bus> busList = new ArrayList<>();
	private User currentUser;
	@Autowired
	UserService service;

	@Autowired
	BusService Busservice;

	@GetMapping("/login")
	public String method() {
		return "userlogin";
	}

	@GetMapping("/signup")
	public String method2() {
		return "usersignup";
	}
	
	@PostMapping("login_into")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {

			User user = service.login(email, password);
			currentUser = user;
			mv.addObject("user", user);
			mv.setViewName("allbuses");
			List<Bus> list = Busservice.AllBusList();
			busList = list;
			mv.addObject("list", list);
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			return mv;

		} catch (Exception e) {

			mv.setViewName("userlogin");
			mv.addObject("Message", "Login failed");
			return mv;
		}

	}
	
	@GetMapping("allbuses")
	public ModelAndView getAllBuses() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", currentUser);
		mv.addObject("list", busList);
		mv.setViewName("allbuses");
		return mv;
	}

	@PostMapping("signup_into")
	public ModelAndView signup(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("phoneno") String phoneno) {
		ModelAndView mv = new ModelAndView();
		try {

			User user = service.signup(email, password, name, phoneno);
			mv.setViewName("userlogin");
			return mv;

		} catch (Exception e) {

			mv.setViewName("usersignup");
			mv.addObject("Message", "Sigup failed");
			return mv;
		}

	}

}