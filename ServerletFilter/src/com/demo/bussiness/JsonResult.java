package com.demo.bussiness;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonResult extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gb2312");
		PrintWriter pw = resp.getWriter();
		//pw.write("{\"Email\":\"zhww@outlook.com\",\"Remark\":\"我来自遥远的东方\"}");
		pw.write("callback('123')");
		pw.flush();
		pw.close();
	}

}
