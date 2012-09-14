package cn.gooloog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.gooloog.bean.PageBean;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;
import cn.gooloog.util.UniqId;

/**
 * 业务bean
 * 
 * @author admin
 * 
 */
@Service
@Transactional
public class UserServiceBean implements UserService {
	/**
	 * 注入SessionFactory
	 */
	@Resource
	SessionFactory factory;

	/**
	 * 删除
	 */
	public void delete(String... usernames) {
		for (String username : usernames) {
			factory.getCurrentSession().delete(
					factory.getCurrentSession().load(User.class, username));
		}
	}

	public User find(Long id) {
		return (User) factory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<User> list(String queryString) {
		Query query = factory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	public boolean save(User user) {
		factory.getCurrentSession().persist(user);
		return true;
	}

	public boolean update(User user) {
		factory.getCurrentSession().merge(user);
		return true;
	}

	public PageBean paging(Integer pageSize, Integer page) {
		int rows = factory.getCurrentSession().createQuery("from User").list()
				.size();
		int totalPage = PageBean.countTotalPage(10, rows);
		int offset = PageBean.countOffset(10, 1);
		int currentPage = PageBean.countCurrentPage(page);
		Query query = factory.getCurrentSession().createQuery("from User");
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		List<?> list = query.list();
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalRows(rows);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
	public User register(User user) {
		user.setSalt(UniqId.getInstance().getUniqIDHashString()
				.substring(0, 13));
		user.setPassword(DigestUtils.md5Hex(user.getPassword() + user.getSalt()));
		this.save(user);
		Query query = factory
				.getCurrentSession()
				.createSQLQuery(
						"SELECT * FROM jt_user WHERE email=? AND password=?")
				.addEntity(User.class);
		query.setString(0, user.getEmail());
		query.setString(1, user.getPassword());
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

	public User login(String email, String password) {
		Query query = factory.getCurrentSession()
				.createSQLQuery("SELECT * FROM jt_user WHERE email=?")
				.addEntity(User.class).setString(0, email);
		@SuppressWarnings("unchecked")
		List<User> users = query.list();
		if (users.isEmpty()) {
			return null;
		}
		User user = users.get(0);
		if (DigestUtils.md5Hex(password + user.getSalt()).equals(
				user.getPassword())) {
			return user;
		}
		return null;
	}
}