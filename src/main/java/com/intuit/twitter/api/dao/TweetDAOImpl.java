package com.intuit.twitter.api.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intuit.twitter.api.model.Follow;
import com.intuit.twitter.api.model.Tweet;

@Repository
public class TweetDAOImpl implements TweetDAO {

	@Autowired
	private EntityManager entityManager;
	
	public List<Tweet> getLatestTweets(Integer userId, Integer maxCount) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query query = currentSession.createQuery(" select t from Tweet t, Follow as f where t.user_id = f.follow_user_id AND f.user_id = :userId order by t.create_time desc");
		
		query.setParameter("userId", userId);
		
		List<Tweet> list = query.getResultList();
		
		if(list!=null && list.size() > maxCount) {
			list=list.subList(0, maxCount);
		}
		return list;
	}

	/*
	public Tweet get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Tweet employeeObj = currentSession.get(Tweet.class, id);
		return employeeObj;
	}
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Tweet employeeObj = currentSession.get(Tweet.class, id);
		currentSession.delete(employeeObj);
	}
*/
	public void tweet(Tweet tweet) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(tweet);
	}

	public void follow(Follow followObject) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(followObject);
	}

	public void unfollow(Follow followObject) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Integer> query = currentSession.createQuery("select id from Follow where user_id = :userId AND follow_user_id = :followUserId", Integer.class);
		query.setParameter("userId", followObject.getUser_id());
		query.setParameter("followUserId", followObject.getFollow_user_id());
		
		Integer searchObject = query.getSingleResult();
		
		delete(searchObject);
	}

	public void delete(int id) {
	
		Session currentSession = entityManager.unwrap(Session.class);
		 
		Follow deleteObj = currentSession.get(Follow.class, id);
		currentSession.delete(deleteObj);
	}


}
