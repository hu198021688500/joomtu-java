package cn.gooloog.service;

import java.util.List;

import cn.gooloog.bean.PageBean;
import cn.gooloog.pojo.User;

/**
 * @author hugb
 * 
 */
public interface UserService {
	/**
	 * 添加
	 * 
	 * @param user
	 */
	public void save(User user);

	/**
	 * 修改
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * 查找
	 * 
	 * @param id
	 * @return
	 */
	public User find(int id);

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
	 * @return
	 */
	public List<User> list(String queryString);

	/**
	 * 分页
	 * 
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public PageBean paging(int pageSize, int page);
}
