package com.cognizant.project.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.project.dao.ExeQuery;
import com.cognizant.project.model.User;

@Service
public class AdminService {
	
	@Autowired
	ExeQuery query;
	
	public void addBus(String name, String source, String destination, int price) {
		
		query.addBus(name, source, destination, price);
		
	}
	
    public int addSchedule(int bus_id, Date date,int seat) {
		return query.addSchedule(bus_id, date, seat);
	}

	public List<User> getAllUser() {
		return query.getAllUser();
	}
	
	public User getUserBasedOnName(String name) {
		return query.getUserBasedOnName(name);
	}

}
