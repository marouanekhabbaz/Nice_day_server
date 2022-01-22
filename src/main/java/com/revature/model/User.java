package com.revature.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.revature.controller.MemoryController;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class User {
	
	private static final Logger log = LoggerFactory.getLogger(MemoryController.class);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
//	@NotBlank
	private String firstName;
//	@NotBlank
	private String lastName;
	
//	@Email
	private String email;
	
	
//	@NotBlank
	private String userName;
	
//	@NotBlank
	private String passWord;
	
    @OneToMany(mappedBy = "user", 
//    		cascade = CascadeType.ALL,
    		orphanRemoval = true)
    @JsonManagedReference
	private List<Memory> memories = new ArrayList<>();
	
	
	public User() {
		super();
	}


	public User(  String firstName, String lastName, String email,
			String userName, String passWord) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
	}
	

	public User(int id,  String firstName,  String lastName,String email,
			 String userName,  String passWord) {
		super();
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
	}

	
	
	
	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public List<Memory> getMemories() {
		return memories;
	}


	public void setMemories(Memory memorie) {
		this.memories.add(memorie); 
	}


	public int getId() {
		return userId;
	}


	public void setId(int id) {
		this.userId = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	@Override
	public String toString() {
		return "User [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", passWord=" + passWord + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, userId, lastName, passWord, userName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && userId == other.userId
				&& Objects.equals(lastName, other.lastName) && Objects.equals(passWord, other.passWord)
				&& Objects.equals(userName, other.userName);
	}
	
	
	
	
	
	
	
	
}
