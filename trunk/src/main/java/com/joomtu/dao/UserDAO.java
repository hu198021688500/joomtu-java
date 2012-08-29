package com.joomtu.dao;

// default package

import com.joomtu.pojo.User;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see .User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String SALT = "salt";
	public static final String OLD_PASSWORD = "oldPassword";
	public static final String NICKNAME = "nickname";
	public static final String SEX = "sex";
	public static final String AVATAR = "avatar";
	public static final String MOBILE = "mobile";
	public static final String BIRTHDAY = "birthday";
	public static final String ADDRESS = "address";
	public static final String RID = "rid";
	public static final String NID = "nid";
	public static final String STATUS = "status";
	public static final String CONFIG = "config";
	public static final String SIGNATURE = "signature";
	public static final String INTEGRAL = "integral";
	public static final String REG_TIME = "regTime";
	public static final String REG_IP = "regIp";
	public static final String REG_SOURCE = "regSource";
	public static final String LAST_LOGIN_TIME = "lastLoginTime";
	public static final String LAST_LOGIN_IP = "lastLoginIp";
	public static final String LOGIN_FAIL_TIMES = "loginFailTimes";
	public static final String RESET_PWD_TIME = "resetPwdTime";
	public static final String UPDATE_TIME = "updateTime";

	protected void initDao() {
		// do nothing
	}

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get("User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<User> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<User> findBySalt(Object salt) {
		return findByProperty(SALT, salt);
	}

	public List<User> findByOldPassword(Object oldPassword) {
		return findByProperty(OLD_PASSWORD, oldPassword);
	}

	public List<User> findByNickname(Object nickname) {
		return findByProperty(NICKNAME, nickname);
	}

	public List<User> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<User> findByAvatar(Object avatar) {
		return findByProperty(AVATAR, avatar);
	}

	public List<User> findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List<User> findByBirthday(Object birthday) {
		return findByProperty(BIRTHDAY, birthday);
	}

	public List<User> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<User> findByRid(Object rid) {
		return findByProperty(RID, rid);
	}

	public List<User> findByNid(Object nid) {
		return findByProperty(NID, nid);
	}

	public List<User> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List<User> findByConfig(Object config) {
		return findByProperty(CONFIG, config);
	}

	public List<User> findBySignature(Object signature) {
		return findByProperty(SIGNATURE, signature);
	}

	public List<User> findByIntegral(Object integral) {
		return findByProperty(INTEGRAL, integral);
	}

	public List<User> findByRegTime(Object regTime) {
		return findByProperty(REG_TIME, regTime);
	}

	public List<User> findByRegIp(Object regIp) {
		return findByProperty(REG_IP, regIp);
	}

	public List<User> findByRegSource(Object regSource) {
		return findByProperty(REG_SOURCE, regSource);
	}

	public List<User> findByLastLoginTime(Object lastLoginTime) {
		return findByProperty(LAST_LOGIN_TIME, lastLoginTime);
	}

	public List<User> findByLastLoginIp(Object lastLoginIp) {
		return findByProperty(LAST_LOGIN_IP, lastLoginIp);
	}

	public List<User> findByLoginFailTimes(Object loginFailTimes) {
		return findByProperty(LOGIN_FAIL_TIMES, loginFailTimes);
	}

	public List<User> findByResetPwdTime(Object resetPwdTime) {
		return findByProperty(RESET_PWD_TIME, resetPwdTime);
	}

	public List<User> findByUpdateTime(Object updateTime) {
		return findByProperty(UPDATE_TIME, updateTime);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}
}