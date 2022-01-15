package com.revature.data;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
	
	public List<User> findByEmailAndPassWord(String email , String passWord);
	

	
	public List<User> findByEmail(String email);	
	
	/**
	 * 
	 * @Modifying(clearAutomatically = true)
    @Query("UPDATE Company c SET c.address = :address WHERE c.id = :companyId")
    int updateAddress(@Param("companyId") int companyId, @Param("address") String address);
	 */
	
}
