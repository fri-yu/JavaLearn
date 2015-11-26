package com.demo.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.domain.User;
import com.demo.util.HibernateUtil;

public class UserService extends BaseService {
	/**
	 * @author Administrator
	 * @param User
	 *            Name
	 * @param User
	 *            Password
	 * @return a user with the same name and password
	 */
	public static User GetUser(String name, String psd) {
		Session session = HibernateUtil.openSession();
		String hql = " from User where name=? and password=?";
		List<User> uList = session.createQuery(hql).setParameter(0, name)
				.setParameter(1, psd).list();

		if (uList.size() == 1) {
			return uList.get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static User GetUser(String cId) {
		Session session = HibernateUtil.openSession();
		String hql = " from User where cId=? ";
		List<User> uList = session.createQuery(hql).setParameter(0, cId).list();

		if (uList.size() == 1) {
			return uList.get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static List<User> GetUserList() {

		Session session = HibernateUtil.openSession();
		String hql = " from User ";
		List<User> uList = session.createQuery(hql).list();
		try {
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return uList;
	}
	public static List<User> GetUserList(int pageSize,int currentPageNumber) {

		Session session = HibernateUtil.openSession();
		String hql = " from User ";
		List<User> uList = session.createQuery(hql).setFirstResult((currentPageNumber-1)*pageSize).setMaxResults(pageSize).list();
		try {
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return uList;
	}

	public static void updateUser(User u) {
		Session session = HibernateUtil.openSession();

		try {
			session.beginTransaction();
			// session.update(u);
			String hsql = " Update User set name=:name ,password=:psd where cid=:cid";
			int resultCount = session.createQuery(hsql)
					.setString("name", u.getName())
					.setString("psd", u.getPassword())
					.setInteger("cid", u.getCid()).executeUpdate();
			System.out.println(resultCount);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static boolean deleteUser(String cid) {
		Session session = HibernateUtil.openSession();

		try {
			Transaction transaction = session.beginTransaction();
			String hql = " delete from User where cid=?";
			int resultCount = session.createSQLQuery(hql).setString(0, cid)
					.executeUpdate();
			System.out.println(resultCount);
			transaction.commit();
			session.close();
			if (resultCount == 1)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
}
