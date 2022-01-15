package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Memory;


@Repository
public interface MemoryRepository  extends JpaRepository<Memory, Integer> {
	
	List<Memory> findAllByUser(int userId);
	
	

}
