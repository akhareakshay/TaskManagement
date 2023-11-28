package com.codewithakshayy.taskmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithakshayy.taskmgmt.document.User;
import com.codewithakshayy.taskmgmt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		User savedUser = userService.saveNewUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@GetMapping(value = "/get/{uid}")
	public ResponseEntity<Object> getUserByUid(@PathVariable String uid) {
		User foundUser = userService.getUserByUid(uid);
		return new ResponseEntity<>(foundUser, HttpStatus.OK);
	}

	@PostMapping(value = "/update/{uid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUserByUid(@PathVariable String uid, @RequestBody User user) {
		User updateUser = userService.updateUser(uid, user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
}
