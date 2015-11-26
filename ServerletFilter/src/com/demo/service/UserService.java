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

	public static int GetUserByPage(int pageSize,int currentPage, List<User> uList) {
		System.out.println("service ulist hash:"+uList.hashCode());
		Session session = HibernateUtil.openSession();
		String hql = " from User ";
		int rowCount=Integer.parseInt(session.createQuery(" select count(*) from User").uniqueResult().toString());
		int pageCount=(rowCount-1)/pageSize+1;
		//System.out.println(rowCount+","+pageCount+"-"+pageSize+"-"+currentPage);
		 uList.addAll(session.createQuery(hql).setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize).list());
		 System.out.println("service ulist hash:"+uList.hashCode());
		try {
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pageCount;
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
