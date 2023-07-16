package com.cognizant.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.project.model.User;
import com.cognizant.project.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	ProfileService service;

	@GetMapping("profile")
	public ModelAndView getProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		User user = service.ShowProfile((String)session.getAttribute("email"));

		mv.addObject("user", user);

		return mv;
	}

	@PostMapping("updatepassword")
	public String updatePassword(@RequestParam("password") String password, HttpSession session) {
		service.changePassword(password, session.getAttribute("email").toString());
		return "redirect:/profile";
	}

	@PostMapping("updatename")
	public String updateName(@RequestParam("name") String name, HttpSession session) {
		service.changeName(name, session.getAttribute("email").toString());
		return "redirect:/profile";
	}

	@PostMapping("updatephoneno")
	public String updatePhoneno(@RequestParam("phoneno") String phoneno, HttpSession session) {
		service.changePhoneno(phoneno, session.getAttribute("email").toString());
		return "redirect:/profile";
	}
}
