package com.incture.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.incture.login.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserViewController {
	

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/all")
	public ModelAndView showAllUsers() {
		var userList=userRepo.findAll();
		var view= new ModelAndView("user-details");
		view.addObject("data", userList);
		return view;
		
	}

}
