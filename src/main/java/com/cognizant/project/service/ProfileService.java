package com.cognizant.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.project.dao.ExeQuery;
import com.cognizant.project.model.User;

@Service
public class ProfileService {
	
	@Autowired
	ExeQuery query;
	
	public User ShowProfile(String email) {
		
	User user = query.getUser(email);
	
	return user;
		
		
	}
	
	public void changePassword(String password,String email) {
		query.updatePassword(password, email);
	}
	
    public void changeName(String name,String email) {
    	query.updateName(name, email);
	}

    public void changePhoneno(String phoneno,String email) {
    	query.updatePhoneno(phoneno, email);
    }

}
