package com.rishika.doctormicroservices.dto;

public class Appointment {
	private int id;
	private String name;
	private String contact;
	private String doctor;
	private String dateTime;
	
	public Appointment() {
		super();
	}
	
	public Appointment(int id, String name, String contact, String doctor, String dateTime) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.doctor = doctor;
		this.dateTime = dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
