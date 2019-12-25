package com.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/input")
public class InputServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// req.getParameterValues(" ")
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		String[] subjects = req.getParameterValues("subject");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		for (String sb : subjects) {
			System.out.println("subject : " + " ");
		}
		System.out.println();
		
		// req.getParameterNames()
		Enumeration enu = req.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String[] values = req.getParameterValues(name);
			for (String value : values) {
				System.out.println("name : " + name + ", value : " + value);
			}
		}
	}
}
