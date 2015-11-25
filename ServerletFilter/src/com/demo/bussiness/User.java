package com.demo.bussiness;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.UserService;

public class User extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String name = req.getParameter("loginName");
		String psd = req.getParameter("loginPsd");
		if (null != name && null != psd && !name.equals("") && !psd.equals("")) {
			if (UserService.GetUser(name, psd)!=null) {
				resp.sendRedirect("welcome");// 跳转到登录成功页面
				return;
			}
		}
		resp.sendRedirect("index.jsp?errInfo=chechFailed");// 跳转到登录页面
	}
}
