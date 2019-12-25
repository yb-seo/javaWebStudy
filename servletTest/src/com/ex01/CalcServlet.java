package com.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/calc")
public class CalcServlet extends HttpServlet {

	/* 환율 계산기 */
	
	private static float USD_RATE = 1124.70f;
	private static float JPY_RATE = 10.113f;
	private static float EUR_RATE = 1295.97f;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String command = req.getParameter("command");
		String won = req.getParameter("won");
		String operator = req.getParameter("operator");
		
		if (command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			out.print("<html>");
			out.print("<font size=10>변환 결과</font><br>");
			out.print("<font size=10>" + result + "</font><br>");
			out.print("<a href='/servletTest/calc'>환율 계산기</a>");
			out.print("</html>");
			return;
		}
		
		out.print("<html>");
		out.print("<font size=5>환율 계산기</font>");
		out.print("<form name='frmCalc' method='get' action='/servletTest/calc'>");
		out.print("원화 : <input type='text' name='won'>");
		out.print("<select name='operator'>");
		out.print("<option value='dollar'>달러</option>");
		out.print("<option value='en'>엔화</option>");
		out.print("<option value='euro'>유로</option>");
		out.print("</select>");
		out.print("<input type='hidden' name='command' value='calculate'>");
		out.print("<input type='submit' value='변환'>");
		out.print("</form>");
		out.print("</html>");
	}
	
	private static String calculate(float won, String op) {
		String result = null;
		
		if(op.equals("dollar")) {
			result = String.format("%.6f", won/USD_RATE);
		} else if (op.equals("en")) {
			result = String.format("%.6f", won/JPY_RATE);
		} else if (op.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		return result;		
	}
}
