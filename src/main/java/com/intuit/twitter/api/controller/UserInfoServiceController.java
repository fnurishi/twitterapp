package com.intuit.twitter.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.twitter.api.model.User;
import com.intuit.twitter.api.service.UserInfoService;

@RestController
@RequestMapping("/userinfoapi")
public class UserInfoServiceController {
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/users/{userId}/{start}/{end}")
	public List<User> getUserList(@PathVariable Integer userId, @PathVariable Integer start, @PathVariable Integer end) {
		List<User> usersList = userInfoService.getUserList(userId, start, end);
		if(usersList == null) {
			throw new RuntimeException("No users found.");
		}
		return usersList;
	}
}
