package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.DAOFactory;
import dao.DAOUser;
import session.HandleSession;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOUser daoUser;
	
    public SigninServlet() {
        super();
    }
    
    public void init() {
    	System.out.println("INIT RUN : SigninServlet class");
    	this.daoUser = ((DAOFactory)getServletContext().getAttribute("daofactory")).getDAOUser();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("SigninServlet class : doGET : /signin");

		this.getServletContext().getRequestDispatcher("/WEB-INF/Auth/signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("SigninServlet class : doPOST : /signin");
		
		AuthenticationForm signinForm = new AuthenticationForm(daoUser);
		
		User user = signinForm.signin(request, response);
		if (user != null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("user_id", user.getId());
			session.setAttribute("user_name", user.getName());
			session.setAttribute("user_email", user.getEmail());
			
		}
		
	}

}
