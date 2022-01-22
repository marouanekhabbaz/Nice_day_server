package com.revature.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.controller.MemoryController;
import com.revature.data.MemoryRepository;
import com.revature.model.Memory;


@Service
public class MemoryService {
	
	private static final Logger log = LoggerFactory.getLogger(MemoryController.class);

	@Autowired
	MemoryRepository memoryRepo;
	
	
	public List<Memory>  findAll(){
		return  memoryRepo.findAll();
	}	
	
	public Memory addMemory(Memory memory) {
		
		return 	memoryRepo.save(memory);
		
	}
	
	
	public List<Memory> findMemoriesOfUser(int id){
		return memoryRepo.findAllByUser(id);
	}
	
	
	public Memory findById(int id ) {
		return memoryRepo.getById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeMemory(int id) {
		
		memoryRepo.deleteById(id);
	
//		System.out.println("here " + id);
		
//		int x =  memoryRepo.deleteByMemoryId(id);
//		System.out.println(x);
	}
	
	
//	public void updateMemory(int id) {
//		memoryRepo.
//	}
	
	
	
	
	
}
