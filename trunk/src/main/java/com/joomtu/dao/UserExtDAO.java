package com.joomtu.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.joomtu.pojo.UserExt;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserExt entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .UserExt
 * @author MyEclipse Persistence Tools
 */

public class UserExtDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UserExtDAO.class);
	// property constants
	public static final String REALLY_NAME = "reallyName";
	public static final String ID_NUMBER = "idNumber";
	public static final String QQ = "qq";
	public static final String INVITEUID = "inviteuid";
	public static final String INVITECODE = "invitecode";
	public static final String ACTIVATIONCODE = "activationcode";

	protected void initDao() {
		// do nothing
	}

	public void save(UserExt transientInstance) {
		log.debug("saving UserExt instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserExt persistentInstance) {
		log.debug("deleting UserExt instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserExt findById(java.lang.Integer id) {
		log.debug("getting UserExt instance with id: " + id);
		try {
			UserExt instance = (UserExt) getHibernateTemplate().get("UserExt",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserExt> findByExample(UserExt instance) {
		log.debug("finding UserExt instance by example");
		try {
			List<UserExt> results = (List<UserExt>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserExt instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserExt as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserExt> findByReallyName(Object reallyName) {
		return findByProperty(REALLY_NAME, reallyName);
	}

	@SuppressWarnings("unchecked")
	public List<UserExt> findByIdNumber(Object idNumber) {
		return findByProperty(ID_NUMBER, idNumber);
	}

	@SuppressWarnings("unchecked")
	public List<UserExt> findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	@SuppressWarnings("unchecked")
	public List<UserExt> findByInviteuid(Object inviteuid) {
		return findByProperty(INVITEUID, inviteuid);
	}

	@SuppressWarnings("unchecked")
	public List<UserExt> findByInvitecode(Object invitecode) {
		return findByProperty(INVITECODE, invitecode);
	}

	@SuppressWarnings("unchecked")
	public List<UserExt> findByActivationcode(Object activationcode) {
		return findByProperty(ACTIVATIONCODE, activationcode);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all UserExt instances");
		try {
			String queryString = "from UserExt";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserExt merge(UserExt detachedInstance) {
		log.debug("merging UserExt instance");
		try {
			UserExt result = (UserExt) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserExt instance) {
		log.debug("attaching dirty UserExt instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserExt instance) {
		log.debug("attaching clean UserExt instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserExtDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserExtDAO) ctx.getBean("UserExtDAO");
	}
}