package ex01.login;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl2
 *
 */
@WebListener
public class LoginImpl2 implements HttpSessionListener {

	String user_id;
	String user_pw;
	static int total_user2 = 0;
	
	public LoginImpl2() {
		// TODO Auto-generated constructor stub
	}
	
    public LoginImpl2(String user_id, String user_pw) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("세션 생성");
    	total_user2++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("세션 해제");
    	total_user2--;
    }
	
}
