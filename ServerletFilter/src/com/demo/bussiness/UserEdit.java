package com.demo.bussiness;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.User;
import com.demo.service.UserService;

public class UserEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		String cid = "";
		try {
			cid = req.getParameter("cid");
			// System.out.println(cid);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e.getMessage());
		}

		if (null != cid) {
			User user = UserService.GetUser(cid);
			System.out.println(user);
			if (user != null) {
				req.setAttribute("user", user);
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("/user/userEdit.jsp");
				dispatcher.forward(req, resp);
			}
		} else {
			resp.sendRedirect("welcome");//不能直接跳转“welcome.jsp”，因为没有对list进行赋值
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this.doGet(req, resp);
		System.out.println(req.getParameter("cid"));
		System.out.println(req.getParameter("uName"));
		System.out.println(req.getParameter("uPsd"));
		UserService.updateUser(new User(Integer.parseInt(req.getParameter("cid")),req.getParameter("uName"),req.getParameter("uPsd")));
		resp.sendRedirect("welcome?type=editSuccess");
	}

}
