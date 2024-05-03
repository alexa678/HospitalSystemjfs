package com.adminmicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private int id;
		@Column(name="name")
		private String name;
		@Column(name="contact")
		private String contact;
		@Column(name="doctor")
		private String doctor;
		@Column(name="dateTime")
		private String dateTime;
		
		public Appointment() {
			
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

