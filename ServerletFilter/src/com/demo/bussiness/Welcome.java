package com.demo.bussiness;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.UserService;
import com.demo.viewModel.UserListModel;

public class Welcome extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		String name = req.getParameter("username") == null ? "" : req
				.getParameter("username").toString().trim();
		String psd = req.getParameter("psd") == null ? "" : req.getParameter(
				"psd").toString();
		if (name != "" && psd != "") {
			if (null != UserService.GetUser(name, psd)) {
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("welcome.jsp");
				dispatcher.forward(req, resp);
			} else {
				resp.sendRedirect("index.html?info=2");
			}
		} else {
			System.out.println("’ ∫≈ªÚ√‹¬ÎŒ™ø’");
			resp.sendRedirect("index.html?info=1");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		this.doGet(req, resp);
	}

}
