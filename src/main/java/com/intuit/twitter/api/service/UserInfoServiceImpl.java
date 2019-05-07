package com.intuit.twitter.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.twitter.api.dao.UserInfoDAO;
import com.intuit.twitter.api.model.User;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDao; 
	
	@Transactional
	public List<User> getUserList(Integer userId, Integer start, Integer end) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserList(userId, start, end);
	}

	// not yet implemented
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
