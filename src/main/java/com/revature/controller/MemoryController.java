package com.revature.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.model.Memory;
import com.revature.model.User;
import com.revature.service.MemoryService;


@RestController
@RequestMapping("/memories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemoryController {
	
	private static final Logger log = LoggerFactory.getLogger(MemoryController.class);
	
	@Autowired
	MemoryService memoryService;
	
	@GetMapping("/")
	public List<Memory> findAll() {
		
		return memoryService.findAll();
		
	}
	
	
	
	@GetMapping("/{id}")
	public Memory findById(@PathVariable("id") int id) { 
	
		return memoryService.findById(id);
	}
	
	@GetMapping("/user/{id}")
	public List<Memory> findByUserId(@PathVariable("id") int id){
		return memoryService.findMemoriesOfUser(id);
	}
	
}
