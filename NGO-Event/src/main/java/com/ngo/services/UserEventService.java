package com.ngo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.entities.UserEvent;
import com.ngo.repos.UserEventRepo;

@Service
public class UserEventService {

	
	
	@Autowired
	UserEventRepo userEventRepo;
	
	//returns all user events
	public ArrayList<UserEvent> getUserEvents(){
		
		
		return (ArrayList<UserEvent>) userEventRepo.findAll();
		
		
	}
	
	public void addUserEvent(UserEvent userEvent) {
		
		userEventRepo.save(userEvent);
		
		
	}
	
	
	//get user event by id
	public UserEvent getUserEvent(int id) {
		return userEventRepo.getUserEventFromId(id);
	}
	
	//delete user event
	public void deleteUserEvent(UserEvent event) {
		userEventRepo.delete(event);
	}

	public void deleteUserEventById(Integer id) {

		userEventRepo.deleteById(id);
	}
	
}