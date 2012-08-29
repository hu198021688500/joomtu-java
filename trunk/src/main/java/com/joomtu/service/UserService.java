/**
 * 
 */
package com.joomtu.service;

import java.util.List;

import com.joomtu.pojo.User;

/**
 * @author admin
 * 
 */
public interface UserService {
	public void save(User user);

	public void update(User user);

	public List<User> searchUsers(String queryString);

	public User find(int id);

	public void delete(String... usernames);

	public List<User> list();
}
