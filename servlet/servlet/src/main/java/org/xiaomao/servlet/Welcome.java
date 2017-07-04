package org.xiaomao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7305279553017026717L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		String n = request.getParameter("userName");
//		out.print("Welcome " + n);
		response.sendRedirect("helloservlet");
	}

}
