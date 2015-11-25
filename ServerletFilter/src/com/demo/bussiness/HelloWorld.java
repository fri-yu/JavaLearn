package com.demo.bussiness;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// System.out.println("get run");

		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		// System.out.println("post run");
		PrintWriter pw = resp.getWriter();
		// req.setCharacterEncoding("utf-8");
		System.out.println(req.getQueryString());
		System.out.println(req.getCharacterEncoding());
		// System.out.println(req.getParameter("name"));
		// String string = req.getParameter("name");
		// System.out.println("string : " + string.getBytes("iso8859-1"));
		// System.out.println(URLDecoder.decode(req.getParameter("name"), "utf-8"));
		// System.out.println(getServletContext().getInitParameter("ss"));
		// System.out.println(new String(req.getParameter("name").getBytes(
		// "iso-8859-1"), "gb2312"));
		System.out.println(req.getParameter("name"));
		System.out.println(new String(req.getParameter("name").getBytes(
				"iso-8859-1"), "utf-8"));
		// System.out.println(new String(req.getParameter("name").getBytes(
		// "iso-8859-1"), "gbk"));
		// System.out.println(new String(req.getParameter("name")
		// .getBytes("utf-8"), "gbk"));
		// System.out.println(new String(req.getParameter("name")
		// .getBytes("utf-8"), "gb2312"));
		pw.write("hello world,£¬11ºº×Ö£ºÊÀ½çÄãºÃ_" + req.getParameter("name"));
		pw.close();
	}

}
