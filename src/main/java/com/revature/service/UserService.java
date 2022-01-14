package com.revature.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.MemoryRepository;
import com.revature.data.UserRepository;

import com.revature.model.User;

@Service
public class UserService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MemoryRepository memoryRepo;
	
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User getByUserId(int id){
		
		User  user = userRepo.getById(id);
		return user;
	}
	
}
