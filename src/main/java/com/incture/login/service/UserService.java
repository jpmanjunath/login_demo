package com.incture.login.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.incture.login.entitiy.UserEntity;
import com.incture.login.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public ResponseEntity<Object> getAllUsers() throws Exception {
		var userList = userRepo.findAll();
		return ResponseEntity.ok(Map.of("size", userList.size(), "data", userList));
	}

	public ResponseEntity<Object> getUserByEmail(String email) {
		try {
			var user = userRepo.findByEmail(email);

			return ResponseEntity.ok(Map.of("data", user));
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("error", "User not found with an email " + email));
		}
	}

	public ResponseEntity<Object> getUserById(String id) {
		try {
			var user = userRepo.findById(id);
			if (user.isEmpty()) {
				throw new Exception("user not found");
			}

			return ResponseEntity.ok(Map.of("data", user));
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("error", "User not found with an id " + id));
		}

	}

	public ResponseEntity<Object> saveOrUpdateUser(UserEntity user) {
		try {
		var updatedUser=	 userRepo.save(user);
			return ResponseEntity.ok(Map.of("data", updatedUser));
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("error", "User save/update failed"));
		}
	}

	public ResponseEntity<Object> deleteUser(String id) {
		try {
			userRepo.deleteById(id);
			return ResponseEntity.ok(Map.of("data", "User deleted for an id " + id));
		} catch (Exception e) {
			return ResponseEntity.ok(Map.of("error", "User not found with an id " + id));
		}

	}

}
