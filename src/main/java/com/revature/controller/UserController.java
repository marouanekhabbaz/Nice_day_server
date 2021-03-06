package com.revature.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Memory;
import com.revature.model.User;
import com.revature.service.MemoryService;
import com.revature.service.UserService;



@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(MemoryController.class);
	
	
	@Autowired
	UserService userServ;
	
	@Autowired
	MemoryService memoryService;
	
	
	@GetMapping("/")
	public List<User> findAll() {
		
		return userServ.getAllUsers();
		
	}
	
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable("id") int id) {
		
		return userServ.getByUserId(id);
	}
	
	
	
	@PostMapping("/find")
	public User findUserByEmailAndPassWord(@RequestBody User user) {
		
		return userServ.findUserByEmailAndPassWord(user.getEmail(), user.getPassWord());
		
	}
	
	
	@GetMapping("/find/{email}")
	public User findUserByEmail(@PathVariable("email") String email) {
		
		return userServ.findUserByEmail(email);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@RequestBody User user) {
		
		System.out.println(user);

		return userServ.addUser(user);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") int id) {
		
		 userServ.deleteUser(id);
	}
	
	
	
	
	@GetMapping("/{id}/memories")
	public List<Memory> findUserMemories(@PathVariable("id") int id) {
		return userServ.getByUserId(id).getMemories();
	}
	
	
	@PostMapping("/add")
	public int addUser(@RequestBody User user) { 
		return  userServ.addUser(user).getId();//  foodService.add(food);
		
	}
	
	
	
	
	@PostMapping("/{id}/addmemory")
	public int addMemoryToUser(@RequestBody Memory memory , @PathVariable("id") int id) { 
		
		memory.setUser(userServ.getByUserId(id));
		
		return memoryService.addMemory(memory).getMemoryId();
	}
	
	
	@PutMapping("/{userId}/memory/{memoryId}")
	public Memory updateMemoryById(@RequestBody Memory memory) {

		return memoryService.addMemory(memory);
		
	}
	
	
	@DeleteMapping("/{userId}/memory/{memoryId}")
	public ResponseEntity  deleteMemory(@PathVariable("userId") int userId , @PathVariable("memoryId") int memoryId ) {
			

		List<Memory> memories =	userServ.getByUserId(userId).getMemories();
		
		System.out.println(memories);
		
		boolean isPresent =	memories.stream().anyMatch(m -> m.getMemoryId()== memoryId);
		 

		
				 
		 if(isPresent) {
			 
			 memoryService.removeMemory(memoryId);
			 
			 return new ResponseEntity(HttpStatus.ACCEPTED);
		 }else {
			 
			 return new ResponseEntity(HttpStatus.NOT_FOUND);
			 
		 }
		
	}
	
	
	
	
	

	
	

}
