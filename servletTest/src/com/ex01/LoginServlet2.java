package com.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

	/* 서블릿 응답 처리 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8"); //응답할 데이터 종류 설정
		
		PrintWriter out = resp.getWriter();
		
		String userId = req.getParameter("user_id");
		String userPw = req.getParameter("user_pw");
		
		String data = 
				"<html>" +
					"<body>" +
						"아이디 : " + userId + "<br>" +
						"비밀번호 : " + userPw + "<br>" +
					"</body>" +
				"</html>";
		
		out.print(data);
	}
}
