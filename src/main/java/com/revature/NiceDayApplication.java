package com.revature;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.revature.data.UserRepository;


@SpringBootApplication
public class NiceDayApplication  {

	public static void main(String[] args) {
		SpringApplication.run(NiceDayApplication.class, args);
	}



	
}
