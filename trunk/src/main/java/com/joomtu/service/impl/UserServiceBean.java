package com.joomtu.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.compass.core.Compass;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTemplate;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.joomtu.pojo.User;
import com.joomtu.service.UserService;

@Service
@Transactional
public class UserServiceBean implements UserService {
	@Resource
	CompassTemplate compassTemplate;
	@Resource
	SessionFactory factory;

	public void delete(String... usernames) {
		for (String username : usernames) {
			factory.getCurrentSession().delete(
					factory.getCurrentSession().load(User.class, username));
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public User find(int id) {
		return (User) factory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<User> list() {
		return factory.getCurrentSession().createQuery("from User").list();
	}

	public void save(User user) {
		factory.getCurrentSession().persist(user);
	}

	public void update(User user) {
		factory.getCurrentSession().merge(user);
	}

	public CompassTemplate getCompassTemplate() {
		return compassTemplate;
	}

	public List<User> searchUsers(String queryString) {

		Compass compass = compassTemplate.getCompass();
		CompassSession session = compass.openSession();
		List<User> list = new ArrayList<User>();
		CompassHits hits = session.queryBuilder().queryString(queryString)
				.toQuery().hits();
		System.out.println("queryString:" + queryString);
		System.out.println("hits:" + hits.getLength());
		for (int i = 0; i < hits.length(); i++) {
			User user = (User) hits.data(i);
			String username = hits.highlighter(i).fragment("username");
			String password = hits.highlighter(i).fragment("password");
			if (username != null) {
				user.setNickname(username);
			}
			if (password != null) {
				user.setPassword(password);
			}
			list.add(user);
			System.out.println(user.getNickname());
			System.out.println(user.getPassword());
		}

		return list;
	}
}