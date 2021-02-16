package com.ngo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int eventId;
	
	String eventName;
	String description;
	int category; //1 = Conference, 2 = Seminar, 3 = presentation
	String startDate;
	String endDate;
	String startTime;
	String endTime;
	String location;
	boolean allowRegistration;
	double adultTicketPrice;
	double childTicketPrice;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	List <UserEvent> userEvents;
	
	public Event() {}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isAllowRegistration() {
		return allowRegistration;
	}
	public void setAllowRegistration(boolean allowRegistration) {
		this.allowRegistration = allowRegistration;
	}
	public double getAdultTicketPrice() {
		return adultTicketPrice;
	}
	public void setAdultTicketPrice(double adultTicketPrice) {
		this.adultTicketPrice = adultTicketPrice;
	}
	public double getChildTicketPrice() {
		return childTicketPrice;
	}
	public void setChildTicketPrice(double childTicketPrice) {
		this.childTicketPrice = childTicketPrice;
	}

	public void setId(Integer id) {
		this.eventId = id;
		
	}
	
	
	
	
}
