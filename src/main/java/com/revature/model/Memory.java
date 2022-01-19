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
	private String date;
	private String description ;
	private double temp;
	private double feels_like;
	private double temp_min;
	private double temp_max;
	private int pressure;
	private int humidity;
	private double speed;
	private String country;
	private int sunrise;
	private int sunset;
	
	public Memory( ) {
	
	}
	
	public Memory( User user, String date, String description, double temp, double feels_like,
			double temp_min, double temp_max, int pressure, int humidity, double speed, String country, int sunrise,
			int sunset) {
		super();
	
		this.user = user;
		this.date = date;
		this.description = description;
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.humidity = humidity;
		this.speed = speed;
		this.country = country;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}



	
	

	public Memory(int memoryId, User user, String date, String description, double temp, double feels_like,
			double temp_min, double temp_max, int pressure, int humidity, double speed, String country, int sunrise,
			int sunset) {
		super();
		this.memoryId = memoryId;
		this.user = user;
		this.date = date;
		this.description = description;
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.humidity = humidity;
		this.speed = speed;
		this.country = country;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Memory [memoryId=" + memoryId + ", user=" + user + ", temp=" + temp + ", feels_like=" + feels_like
				+ ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", pressure=" + pressure + ", humidity="
				+ humidity + ", speed=" + speed + ", country=" + country + ", sunrise=" + sunrise + ", sunset=" + sunset
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, feels_like, humidity, memoryId, pressure, speed, sunrise, sunset, temp, temp_max,
				temp_min, user);
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
		return Objects.equals(country, other.country)
				&& Double.doubleToLongBits(feels_like) == Double.doubleToLongBits(other.feels_like)
				&& humidity == other.humidity && memoryId == other.memoryId && pressure == other.pressure
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed) && sunrise == other.sunrise
				&& sunset == other.sunset && Double.doubleToLongBits(temp) == Double.doubleToLongBits(other.temp)
				&& Double.doubleToLongBits(temp_max) == Double.doubleToLongBits(other.temp_max)
				&& Double.doubleToLongBits(temp_min) == Double.doubleToLongBits(other.temp_min)
				&& Objects.equals(user, other.user);
	}

	public int getMemoryId() {
		return memoryId;
	}

	public void setMemoryId(int memoryId) {
		this.memoryId = memoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSunrise() {
		return sunrise;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

	public int getSunset() {
		return sunset;
	}

	public void setSunset(int sunset) {
		this.sunset = sunset;
	}
	
	
	
	
	
	
	
	
	
	
	
}
