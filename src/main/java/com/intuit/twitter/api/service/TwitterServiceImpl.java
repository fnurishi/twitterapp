package com.intuit.twitter.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.twitter.api.dao.TweetDAO;
import com.intuit.twitter.api.model.Follow;
import com.intuit.twitter.api.model.Tweet;

@Service
public class TwitterServiceImpl implements TwitterService {

	@Autowired
	private TweetDAO tweetDAO; 
	

	@Transactional
	public void tweet(Tweet tweet) {
		// TODO Auto-generated method stub
		tweetDAO.tweet(tweet);
	}
	
	@Transactional
	public void follow(Follow followObject) {
		// TODO Auto-generated method stub
		tweetDAO.follow(followObject);
	}
	@Transactional
	public void unfollow(Follow followObject) {
		tweetDAO.unfollow(followObject);
	}
	@Transactional
	public List<Tweet> getLatestTweets(Integer userId, Integer maxCount) {
		
		// TODO Auto-generated method stub
		return tweetDAO.getLatestTweets(userId, maxCount);
	}
}
