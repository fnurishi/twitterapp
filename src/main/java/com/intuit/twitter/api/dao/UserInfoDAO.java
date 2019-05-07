package com.intuit.twitter.api.dao;

import java.util.List;

import com.intuit.twitter.api.model.User;

public interface UserInfoDAO {

	List<User> getUserList(Integer userId, Integer start, Integer end);
}
