package cn.gooloog.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory factory;

	static {
		Configuration cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory(new ServiceRegistryBuilder()
				.buildServiceRegistry());
	}

	public static SessionFactory buildSessionFactory() {
		return factory;
	}

	public Session getSession() {
		return factory.getCurrentSession();
	}

	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}