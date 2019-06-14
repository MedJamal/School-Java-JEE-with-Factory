package session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.User;

public class HandleSession {
	
	private HttpSession session;
	
	public HandleSession (HttpServletRequest request) {
		this.session = request.getSession(false);
	}
	
	public boolean storeUser(User user) {
		
		try {
			
			this.session.setAttribute("user", user);
			
//			//days
//			this.session.setMaxInactiveInterval(7 * 24 * 60 * 60);
			
			// 5 min (for testing)
			this.session.setMaxInactiveInterval(5*60);
			
			return true;
			
		} catch (Exception error) {
			
			System.out.println("Session: Store user error");
			System.out.println(error.getMessage());
			System.out.println(error);
			
			return false;
		}

	}
	
	public User retriveUser() {
		try {
			
			return (User) this.session.getAttribute("user");
			
		} catch (Exception error) {
			
			System.out.println("Session: retrive user error");
			System.out.println(error.getMessage());
			System.out.println(error);
			
			return null;
		}
	}
	
	public boolean signout() {
		try {
			
			this.session.invalidate();
			return true;
			
		} catch (Exception error) {
			System.out.println("Session: destroy user error");
			System.out.println(error.getMessage());
			System.out.println(error);
			
			return false;
		}
	}

	public void alertSuccess(String message) {
		this.session.setAttribute("alertSuccess", message);
	}
	
	public void alertWarning(String message) {
		this.session.setAttribute("alertWarning", message);
	}
	
	public void alertDanger(String message) {
		this.session.setAttribute("alertDanger", message);
	}
	
}
