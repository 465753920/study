package org.xiaomao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Checkbox extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8399830999107542695L;

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html; charset=utf-8");
		
		Enumeration enums = request.getAttributeNames();

		PrintWriter out = response.getWriter();
		String title = "Reading Checkbox Data";

		String docType = "<!DOCTYPE html>\n";

		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n" 
						+ "<h2 align=\"center\">Welcome " + Utils.getNewString(request.getParameter("name")) + "</h2>\n"
						+ "<ul>\n" + "  <li><b>Maths Flag : </b>: "
						+ request.getParameter("maths") + "\n" + "  <li><b>Physics Flag: </b>: "
						+ request.getParameter("physics") + "\n" + "  <li><b>Chemistry Flag: </b>: "
						+ request.getParameter("chemistry") + "\n" + "</ul>\n" + "</body></html>");
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
