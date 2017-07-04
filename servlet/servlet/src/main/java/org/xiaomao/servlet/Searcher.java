package org.xiaomao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Searcher extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6199628607231328887L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		response.sendRedirect("https://www.baidu.com/s?wd=" + name);
	}

}
