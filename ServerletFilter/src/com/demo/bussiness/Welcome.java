package com.demo.bussiness;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.UserService;

public class Welcome extends HttpServlet {

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
		// pw.write("»¶Ó­µÇÂ¼");

		List<com.demo.domain.User> uList = UserService.GetUserList();
		req.setAttribute("uList", uList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(req, resp);
	}

}
