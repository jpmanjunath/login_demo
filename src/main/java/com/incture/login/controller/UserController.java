package com.incture.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incture.login.entitiy.UserEntity;
import com.incture.login.service.UserService;


@RestController
@RequestMapping( "/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<Object> getAllUsers() throws Exception{
		return userService.getAllUsers();
	}
	
	@GetMapping("/byEmail/{email}")
	public ResponseEntity<Object> getUserByEmail(@PathVariable String email){
		return userService.getUserByEmail(email);
	}
	
	@GetMapping("/byId")
	public ResponseEntity<Object> getUserById(@RequestParam String id){
		return userService.getUserById(id);
	}

	@PostMapping("/saveOrUpdate")
	public ResponseEntity<Object> saveOrUpdateUser(@RequestBody UserEntity user){
		return userService.saveOrUpdateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id){
		return userService.deleteUser(id);
	}
	

}
