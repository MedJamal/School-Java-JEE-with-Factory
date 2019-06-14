package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.DAOFactory;
import dao.DAOStudent;
import session.HandleSession;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOStudent daoStudent;
	
    public StudentServlet() {
        super();
    }
    
    public void init() {
    	System.out.println("INIT RUN");
    	this.daoStudent = ((DAOFactory)getServletContext().getAttribute("daofactory")).getDAOStudent();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HandleSession handleSession = new HandleSession(request);
		
		User user = handleSession.retriveUser();
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/signin");
		} else {
			
			System.out.println("GET RUN: /students");

			request.setAttribute("students", daoStudent.getAll());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/students.jsp").forward(request, response);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HandleSession handleSession = new HandleSession(request);
		
		User user = handleSession.retriveUser();
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/signin");
		} else {
			System.out.println("POST RUN: /students");
			
			StudentSignupForm studentSignupForm = new StudentSignupForm(daoStudent);
			
			// Check if values are !empty
			if (!(studentSignupForm.studentSignup(request, response) == null)) {
				
				// replace with session messages for success !!!!
				System.out.println("SERVLET do POST: Confirm values has been added!");
				
//				request.setAttribute("alertSuccess", "Values has been added successfully! fron servlet request attribute");
				
				handleSession.alertSuccess("Student has been added successfully!");
				
			} else {
				System.out.println("SERVLET do POST: Empty values from request");
			}
			
			response.sendRedirect(request.getContextPath() + "/students");
		}
		
	}

}

