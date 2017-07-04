package org.xiaomao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9107468549594320486L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html; charset=utf-8");

		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<b>hello generic servlet你好</b>");
		out.print("</body></html>");

	}
}
