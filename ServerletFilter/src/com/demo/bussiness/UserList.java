package com.demo.bussiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.UserService;
import com.demo.util.PagerUtil;
import com.demo.viewModel.UserListModel;

public class UserList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		// PrintWriter pw = resp.getWriter();
		// pw.write("欢迎登录");

		// List<com.demo.domain.User> uList = UserService.GetUserList();
		UserListModel model = initModel(req);
		req.setAttribute("model", model);
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/user/userList.jsp");
		dispatcher.forward(req, resp);
	}

	private UserListModel initModel(HttpServletRequest req) {
		// TODO Auto-generated method stub
		StringBuilder sBuilder = new StringBuilder();
		List<String> params = new ArrayList<String>();

		UserListModel model = new UserListModel();
		int pageSize = req.getParameter("pageSize") == null ? 5 : Integer
				.parseInt(req.getParameter("pageSize").trim());// 默认每页10条
		int currentPage = req.getParameter("currentPage") == null ? 1 : Integer
				.parseInt(req.getParameter("currentPage").trim());// 默认第一页
		String queryString = "";
		String queryName = req.getParameter("queryName") == null ? "" : req
				.getParameter("queryName").trim();
		// System.out.println("queryString++++"+queryString);
		if (!"".equals(queryName)) {
			sBuilder.append(" and name like ? ");
			params.add("%" + queryName + "%");// 这里注意hibernate的like用法！！！
			queryString += "&queryName=" + queryName;
		}
		if (req.getParameter("queryAge") != null
				&& !"".equals(req.getParameter("queryAge").trim())) {
			int queryAge = Integer
					.parseInt(req.getParameter("queryAge").trim());
			sBuilder.append(" and age=? ");
			params.add(queryAge + "");
			queryString += "&queryAge=" + queryAge;
		}
		sBuilder.append(" Order by cid desc ");

		List<com.demo.domain.User> uList = new ArrayList<com.demo.domain.User>();
		int pageCount = UserService.GetUserByPage(pageSize, currentPage, uList,
				sBuilder.toString(), params);

		// System.out.println("bussiness ulist hash:" + uList.hashCode());
		model.setuList(uList);

		// System.out.println(model.getuList().hashCode());
		model.setPageCount(pageCount);
		model.setPageSize(pageSize);
		model.setCurrentPage(currentPage);
		// 设置分页
		model.setPageLinkDic(PagerUtil.getPagerMap(model.getPageCount(),
				model.getCurrentPage(), model.getPageSize(), queryString));

		return model;
	}
}
