package org.xiaomao.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	// private String message;
	// private Integer counter;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1068403529670481173L;

	@Override
	public void init() throws ServletException {
		// Do required initialization
		System.out.println("init()");
		// message = "Hello World, HAHA";
		// counter = 0;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(counter++);
		// Set response content type
		response.setContentType("text/html");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<h1>HAHA</h1>");

		ServletConfig config = getServletConfig();
		ServletContext ctx = config.getServletContext();
		String name = config.getInitParameter("name");
		String age = config.getInitParameter("age");
		out.println("<h3>Name: " + name + "</h3>");
		out.println("<h3>Age: " + age + "</h3>");
		out.println("<h3>ContextPath: " + ctx.getContextPath() + "</h3>");

		// set this request's attributes
		request.setAttribute("attr_one", "one");
		request.setAttribute("attr_two", "two");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> attributeNames = request.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			System.out.println(attributeNames.nextElement());
		}

		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			System.out.println(paramNames.nextElement());
		}

		try {
			ServletInputStream in = request.getInputStream();
			byte[] b = new byte[512];
			while (in.read(b) != -1) {
				System.out.println(new String(b));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// try {
		// ServletInputStream in = request.getInputStream();
		// InputStreamReader reader = new InputStreamReader(in);
		// BufferedReader bufferedReader = new BufferedReader(reader);
		// while (bufferedReader.ready()) {
		// String line = bufferedReader.readLine();
		// System.out.println(line);
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	@Override
	public void destroy() {
		System.out.println("destroy()");
		// do nothing.
	}

}
