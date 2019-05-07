package com.intuit.twitter.api.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intuit.twitter.api.model.User;
@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	private EntityManager entityManager;
	
	public List<User> getUserList(Integer userId, Integer start, Integer end) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> query = currentSession.createQuery("from User t where t.id <> :userId",User.class);
		
		query.setParameter("userId", userId);
		
		query.setFirstResult((start-1) * end); 
		query.setMaxResults(end);
		
		List<User> list = query.getResultList();
		
		return list;
	}

}
