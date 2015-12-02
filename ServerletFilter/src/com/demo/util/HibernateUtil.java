package com.demo.util;

import java.lang.management.ManagementFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	public static Session getCurrentSession() {
		Session session = threadLocal.get();
		// System.out.println("threadLocal hashcode =" +
		// threadLocal.hashCode());
		// System.out.println("current thread  =" +
		// ManagementFactory.getRuntimeMXBean().getName());
		if (null == session) {
			session = sessionFactory.openSession();
			threadLocal.set(null);
			threadLocal.set(session);
		}
		return session;
	}

	public static Session openSession() {
		// System.out.println("threadLocal hashcode =" +
		// threadLocal.hashCode());
		// System.out.println("current thread  =" +
		// ManagementFactory.getRuntimeMXBean().getName());
		return sessionFactory.openSession();

	}
}
