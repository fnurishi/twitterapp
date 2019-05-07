package com.intuit.twitter.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.twitter.api.model.Follow;
import com.intuit.twitter.api.model.Tweet;
import com.intuit.twitter.api.service.TwitterService;

@RestController
@RequestMapping("/twitterapi")
public class TwitterAppController {

	@Autowired
	private TwitterService twitterService;
	
	@PostMapping("/tweet")
	public Tweet save(@RequestBody Tweet tweetObj) {
		twitterService.tweet(tweetObj);
		return tweetObj;
	}
	
	
	@GetMapping("/latesttweets/{userId}/{maxcount}")
	public List<Tweet> getLatestTweets(@PathVariable Integer userId, @PathVariable Integer maxcount) {
		List<Tweet> tweetList = twitterService.getLatestTweets(userId,maxcount);
		if(tweetList == null) {
			throw new RuntimeException("Tweets not found for the Id:"+userId);
		}
		return tweetList;
	}
	
	@PostMapping("/follow")
	public void follow(@RequestBody Follow followObject) {
		twitterService.follow(followObject);
	}
	
	@PostMapping("/unfollow")
	public void unfollow(@RequestBody Follow followObject) {
		twitterService.unfollow(followObject);
	}
	
	/*
	 * 
	@PutMapping("/tweet")
	public Tweet update(@RequestBody Tweet tweet) {
		twitterService.tweet(tweet);
		return employeeObj;
	}
	
	@DeleteMapping("/tweet/{id}")
	public String delete(@PathVariable int id) {
		twitterService.delete(id);
		return "Tweet has been deleted with id:"+id;
	}
	*/
}
