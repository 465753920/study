package org.xiaomao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5641156255612621552L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html; charset=utf-8");

//		try {
//			ServletInputStream in = request.getInputStream();
//			byte[] b = new byte[512];
//			while (in.read(b) != -1) {
//				System.out.println(new String(b));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		String firstName = Utils.getNewString(request.getParameter("first_name"));
		String lastName = Utils.getNewString(request.getParameter("last_name"));

		PrintWriter out = response.getWriter();
		String title = "Using GET Method to Read Form Data";

		String docType = "<!DOCTYPE html>\n";

		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
				+ "  <li><b>First Name</b>: " + firstName + "\n" + "  <li><b>Last Name</b>: " + lastName + "\n"
				+ "</ul>\n" + "</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
