package ex01.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    ServletContext context2; 
	List user_list2 = new ArrayList();  //로그인한 접속자 ID 저장
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		context2 = getServletContext();  ////////////
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl2 loginUser = new LoginImpl2(user_id, user_pw);
		
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list2.add(user_id);  /////////////
			context2.setAttribute("user_list2", user_list2);
		} 
		
		out.println("<script type='text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");  //5초마다 서블릿에 재요청하여 현재 접속자수 새로고침
		out.println("</script>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자 수는 " + LoginImpl2.total_user2 + "<br>");
		out.println("접속 아이디 : <br>");
		List list = (ArrayList)context2.getAttribute("user_list2");
		for(int i=0; i<list.size(); i++) {
			out.println(list.get(i) + "<br>");
		}
		out.println("<a href='logout?user_id="+user_id+"'>로그아웃</a>");
	}
}
