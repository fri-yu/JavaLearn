package com.demo.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.util.HibernateUtil;

public class BaseService {
	public static int getList(int pageSize, int currentPage, List modelList,
			String tableName, String hqlWhere, List<String> params) {
		Session session = HibernateUtil.openSession();

		Query queryCount = session.createQuery(" select count(*) from "
				+ tableName + " where 1=1 " + hqlWhere);
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				queryCount.setParameter(i, params.get(i));
			}
		}
		int rowCount = Integer.parseInt(queryCount.uniqueResult().toString());
		int pageCount = (rowCount - 1) / pageSize + 1;
		Query query = session
				.createQuery(" from " + tableName + " where 1=1 " + hqlWhere)
				.setFirstResult((currentPage - 1) * pageSize)
				.setMaxResults(pageSize);
		// System.out.println( paramS.size());
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		modelList.addAll(query.list());
		try {
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeSession(session);
		}
		return pageCount;
	}

	private static void closeSession(Session session) {
		if (session != null && session.isOpen())
			session.close();
	}
}
