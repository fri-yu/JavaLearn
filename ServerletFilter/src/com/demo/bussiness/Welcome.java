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
import com.demo.viewModel.WelComeModel;

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
		// pw.write("欢迎登录");

		// List<com.demo.domain.User> uList = UserService.GetUserList();
		WelComeModel model = initModel(req);
		req.setAttribute("model", model);
		RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(req, resp);
	}

	private WelComeModel initModel(HttpServletRequest req) {
		// TODO Auto-generated method stub
		WelComeModel model = new WelComeModel();
		int pageSize = req.getParameter("pageSize") == null ? 10 : Integer
				.parseInt(req.getParameter("pageSize"));// 默认每页10条
		int currentPage = req.getParameter("currentPage") == null ? 1 : Integer
				.parseInt(req.getParameter("currentPage"));// 默认第一页
		List<com.demo.domain.User> uList = new ArrayList<com.demo.domain.User>();
		int pageCount = UserService.GetUserByPage(pageSize, currentPage, uList);

		System.out.println("bussiness ulist hash:" + uList.hashCode());
		model.setuList(uList);
		System.out.println(model.getuList().hashCode());
		model.setPageCount(pageCount);
		model.setPageSize(pageSize);
		model.setCurrentPage(currentPage);
		// 设置分页
		if (model.getPageCount() > 0) {
			model.setPageLinkDic(new LinkedHashMap<String, String>());
			model.getPageLinkDic().put("&pageSize=" + model.getPageSize() + "",
					"首页");
			if (pageCount > 5) {
				if (currentPage > 3)
					model.getPageLinkDic().put("<-", "...");
			}
			if (currentPage < 3) {
				model.getPageLinkDic().put(
						"&pageSize=" + model.getPageSize() + "&currentPage=1",
						"1");
				model.getPageLinkDic().put(
						"&pageSize=" + model.getPageSize() + "&currentPage=2",
						"2");
				model.getPageLinkDic().put(
						"&pageSize=" + model.getPageSize() + "&currentPage=3",
						"3");
				model.getPageLinkDic().put(
						"&pageSize=" + model.getPageSize() + "&currentPage=4",
						"4");
				model.getPageLinkDic().put(
						"&pageSize=" + model.getPageSize() + "&currentPage=5",
						"5");
			} else {
				if (currentPage < pageCount - 2) {
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage="
									+ (model.getCurrentPage() - 2),
							model.getCurrentPage() - 2 + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage="
									+ (model.getCurrentPage() - 1),
							model.getCurrentPage() - 1 + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage="
									+ (model.getCurrentPage()),
							model.getCurrentPage() + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage="
									+ (model.getCurrentPage() + 1),
							model.getCurrentPage() + 1 + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage="
									+ (model.getCurrentPage() + 2),
							model.getCurrentPage() + 2 + "");
				} else {
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage=" + (pageCount - 4),
							pageCount - 4 + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage=" + (pageCount - 3),
							pageCount - 3 + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage=" + (pageCount - 2),
							pageCount - 2 + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage=" + (pageCount - 1),
							pageCount - 1 + "");
					model.getPageLinkDic().put(

							"&pageSize=" + model.getPageSize()
									+ "&currentPage=" + (pageCount),
							pageCount + "");
				}
			}
			if (pageCount > 5) {
				System.out.println(pageCount + "-" + currentPage);
				if (model.getPageCount() - model.getCurrentPage() > 2) {
					model.getPageLinkDic().put("->", "...");
				}
			}
			model.getPageLinkDic().put(
					"&pageSize=" + model.getPageSize() + "&currentPage ="
							+ model.getPageCount(), "尾页");
		}
		return model;
	}

}
