package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.HandleSession;

@WebServlet("/signout")
public class SignoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignoutServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HandleSession handleSession = new HandleSession(request);
		
		if (handleSession.retriveUser() != null) {
			System.out.println("Signout: servlet get");
			
			handleSession.signout();
			
			response.sendRedirect(request.getContextPath() + "/signin");
			
		} else {
			response.sendRedirect(request.getContextPath() + "/signin");
		}
		
		
		
	}

}
