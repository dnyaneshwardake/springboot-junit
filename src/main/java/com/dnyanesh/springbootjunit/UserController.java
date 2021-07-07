package com.dnyanesh.springbootjunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dnyanesh.springbootjunit.model.UserInfo;
import com.dnyanesh.springbootjunit.service.UserService;

@RestController("/hello")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public UserInfo adduserInfo(@RequestBody UserInfo userInfo) {
		return userService.addUser(userInfo);
	}
	
	@GetMapping("/{id}")
	public Boolean getuserInfo(@PathVariable Long id) {
		return userService.getUserInfo(id);
	}
}
