package ex01.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		} 
		
		out.println("<script type='text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");  //5초마다 서블릿에 재요청하여 현재 접속자수 새로고침
		out.println("</script>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자 수는 " + LoginImpl.total_user + "<br>");
	}
}
