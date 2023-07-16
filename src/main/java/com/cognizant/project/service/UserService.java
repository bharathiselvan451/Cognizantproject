package com.cognizant.project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.project.dao.ExeQuery;
import com.cognizant.project.model.User;

@Service
public class UserService {
	
	User userModel;

	@Autowired
	ExeQuery query;
	
	public User login(String email, String password) throws Exception {
		User user = query.getUser(email);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			throw new Exception("Login Failed");
		}
	}

	public User signup(String email, String password, String name, String Phoneno) throws Exception {

		if (query.addUser(email, name, password, Phoneno) > 0) {
			User user = new User(email, name, password, Phoneno);
			return user;
		} else {
			throw new Exception("Signup Failed");
		}
	}

	public String getName(String email) {
		return query.getName(email);
	}
	

}