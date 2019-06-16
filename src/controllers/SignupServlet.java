package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.DAOFactory;
import dao.DAOUser;
import session.HandleSession;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOUser daoUser;
	
    public SignupServlet() {
        super();
    }
    
    public void init() {
    	System.out.println("INIT RUN : SignupServlet class");
    	this.daoUser = ((DAOFactory)getServletContext().getAttribute("daofactory")).getDAOUser();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HandleSession handleSession = new HandleSession(request);
		
		User user = handleSession.retriveUser();
		
		if (user != null) {
			response.sendRedirect(request.getContextPath() + "/students");
		} else {
			System.out.println("SignupServlet class : doGET : /signup");
			this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/signup.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HandleSession handleSession = new HandleSession(request);
		
		User user = handleSession.retriveUser();
		
		if (user != null) {
			response.sendRedirect(request.getContextPath() + "/students");
		} else {
			System.out.println("SignupServlet class : doPOST : /signup");
			
			AuthenticationForm signupForm = new AuthenticationForm(daoUser);
			
			// Check if values are !empty
			if (!(signupForm.signup(request, response) == null)) {
				
				// replace with session messages for success !!!!
				System.out.println("SERVLET  do POST: Confirm values has been added!");
			} else {
				System.out.println("SERVLET do POST: Empty values from request");
			}
			
			response.sendRedirect(request.getContextPath() + "/signin");
		}
		
		
	}

}
