package cn.gooloog.service;

import java.util.List;

import cn.gooloog.bean.PageBean;
import cn.gooloog.pojo.user.User;

/**
 * 用户业务
 * @author hugb
 * 
 */
public interface UserService {
	/**
	 * 添加
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean save(User user);

	/**
	 * 修改
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean update(User user);

	/**
	 * 查找
	 * 
	 * @param id
	 * @return User
	 */
	public User find(Long id);

	/**
	 * 删除
	 * 
	 * @param usernames
	 */
	public void delete(String... usernames);

	/**
	 * 查找用户列表
	 * 
	 * @param queryString
	 * @return List
	 */
	public List<User> list(String queryString);

	/**
	 * 分页
	 * 
	 * @param pageSize
	 * @param page
	 * @return PageBean
	 */
	public PageBean paging(Integer pageSize, Integer page);
	
	/**
	 * 用户注册
	 * @param user
	 * @return boolean
	 */
	//public boolean register(User user);
	
	public Boolean login(String username, String password, Boolean remember);
	
	//public boolean logout();
	
}