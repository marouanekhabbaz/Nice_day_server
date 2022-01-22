package com.revature.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.UserController;
import com.revature.data.MemoryRepository;
import com.revature.data.UserRepository;
import com.revature.model.User;
import com.revature.service.UserService;

@SpringBootTest
class NiceDayApplicationTests {
	
	@InjectMocks
	private UserService userv;
	
	@Mock
	private UserRepository userRepoMock;
	
	@Mock
	private MemoryRepository memoryRepoMock;
	

	
	@BeforeEach
	public void setup() {

//		MockitoAnnotations.initMocks(this);
		
	}
	
	
	@Test
	public void testMakeCallNotNull() {
		// arrange
		User dummyUser = new User("fred", "frederson", "fred@fred.com", "fredFred", "1234");
		Mockito.when(userRepoMock.getById(1)).thenReturn(dummyUser);
		// act
		User testResult = userv.getByUserId(1);
		// assert
		assertEquals(dummyUser, testResult);
//		assertEquals("kevin", testResult.getFirstName());
		
	}

}
