package cn.gooloog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.gooloog.bean.PageBean;
import cn.gooloog.pojo.user.User;
import cn.gooloog.service.UserService;

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

	public User find(long id) {
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

	public PageBean paging(int pageSize, int page) {
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
}