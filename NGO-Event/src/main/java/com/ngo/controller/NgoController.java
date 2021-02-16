package com.ngo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.entities.Event;
import com.ngo.entities.User;
import com.ngo.entities.UserEvent;
import com.ngo.services.EventService;
import com.ngo.services.UserEventService;
import com.ngo.services.UserService;


@RestController
public class NgoController {

	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserEventService userEventService;
	
	
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getUsers(){
		
		List<User> userList = userService.returnUsers();
		
		return userList;
		
	}
	
	@CrossOrigin
	@GetMapping("/events")
	public List<Event> getEvents(){
		
		List<Event> eventList = eventService.returnEvents();
		
		return eventList;
		
	}
	
	@CrossOrigin
	@GetMapping("/userevents")
	public List<UserEvent> getUserEvents(){
		
		List<UserEvent> userEventList = userEventService.getUserEvents();
		
		return userEventList;
		
	}
	
	@CrossOrigin
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@CrossOrigin
	@PostMapping("/events")
	public void addEvent(@RequestBody Event event) {
		eventService.addEvent(event);
	}
		
	@CrossOrigin
	@PostMapping("/userevents")
	public void addUserEvent(@RequestBody UserEvent userEvent) {
		userEventService.addUserEvent(userEvent);
	}
	
	@CrossOrigin
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Integer id) {
	    try {
	        User existUser = userService.getUserFromId(id);
	        System.out.println(existUser);
	        user.setId(id);
	        userService.addUser(user);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}

	@CrossOrigin
	@PutMapping("/event/{id}")
	public ResponseEntity<?> updateEvent(@RequestBody Event event, @PathVariable Integer id) {
	    try {
	        Event existEvent = eventService.getEventById(id);
	        event.setId(id);
	        eventService.addEvent(event);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUserById(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/events/{id}")
	public void deleteEvent(@PathVariable Integer id) {
		eventService.deleteEventById(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/userevents/{id}")
	public void deleteUserEvent(@PathVariable Integer id) {
		userEventService.deleteUserEventById(id);
	}
	
}
