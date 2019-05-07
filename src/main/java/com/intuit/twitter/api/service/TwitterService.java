package com.intuit.twitter.api.service;

import java.util.List;

import com.intuit.twitter.api.model.Follow;
import com.intuit.twitter.api.model.Tweet;

public interface TwitterService {
	
	void tweet(Tweet tweet);
	void follow(Follow followObject);
	void unfollow(Follow followObject);
	List<Tweet> getLatestTweets(Integer userId, Integer maxCount);
}
