package ex01.login;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {
	String user_id;
	String user_pw;
	static int total_user = 0; //세션에 바인딩 시 1씩 증가

	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// 세션 바인딩 시 수행
		System.out.println("사용자 접속");
		total_user++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// 세션 언바인딩 시 수행
		System.out.println("사용자 접속 해제");
		total_user--;
	}
	
}
