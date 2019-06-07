package session;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandleSession {
	
	public static void handleSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session == null) {
			System.out.println("NUUUL");
			try {
				response.sendRedirect(request.getServletContext() + "/signin");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("NOT NULLLL");
		}
		
	}
	
}
