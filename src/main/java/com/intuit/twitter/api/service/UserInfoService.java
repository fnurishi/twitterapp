package com.intuit.twitter.api.service;

import java.util.List;

import com.intuit.twitter.api.model.User;

public interface UserInfoService {
	List<User> getUserList(Integer userId, Integer start, Integer end);
	User getUser(Integer userId);
}
