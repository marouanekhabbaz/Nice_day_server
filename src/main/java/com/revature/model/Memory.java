package com.revature.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="memories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Memory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="memory_id")
	private int memoryId ;
	//targetEntity = User.class
	@ManyToOne()
	@JoinColumn(name= "user_id")
	@JsonBackReference
	private User user;
	
	private String memoryDay;
	private String description;
	private int temprature ;
	
	
	public Memory( ) {
	
	}
	
	
	
	
	
	
	
	

	public Memory(User user, String memoryDay, String description, int temprature) {
		super();
		this.user = user;
		this.memoryDay = memoryDay;
		this.description = description;
		this.temprature = temprature;
	}









	public Memory(int id, User user, String memoryDay, String description, int temprature) {
		super();
		this.memoryId = id;
		this.user = user;
		this.memoryDay = memoryDay;
		this.description = description;
		this.temprature = temprature;
	}









	@Override
	public int hashCode() {
		return Objects.hash(description, memoryId, memoryDay, temprature, user);
	}









	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Memory other = (Memory) obj;
		return Objects.equals(description, other.description) && memoryId == other.memoryId
				&& Objects.equals(memoryDay, other.memoryDay) && temprature == other.temprature
				&& Objects.equals(user, other.user);
	}









	@Override
	public String toString() {
		return "Memory [id=" + memoryId + ", user=" + user + ", memoryDay=" + memoryDay + ", description=" + description
				+ ", temprature=" + temprature + "]";
	}









	public int getId() {
		return memoryId;
	}


	public void setId(int id) {
		this.memoryId = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public void setUserId(int id) {
		this.user.setId(id);
	}


	public String getMemoryDay() {
		return memoryDay;
	}


	public void setMemoryDay(String memoryDay) {
		this.memoryDay = memoryDay;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getTemprature() {
		return temprature;
	}


	public void setTemprature(int temprature) {
		this.temprature = temprature;
	}

	
	
	
	
	

	
	
	
	
	
	
}
