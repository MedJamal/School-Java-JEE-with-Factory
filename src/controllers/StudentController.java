package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.DAOStudent;

@WebServlet("/students")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOStudent daoStudent;
	
    public StudentController() {
        super();
    }
    
    public void init() {
    	System.out.println("INIT RUN");
    	this.daoStudent = ((DAOFactory)getServletContext().getAttribute("daofactory")).getDAOStudent();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET RUN: /students");

		request.setAttribute("students", daoStudent.getAll());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST RUN: /students");
		
		StudentSignupForm studentSignupForm = new StudentSignupForm(daoStudent);
		
		studentSignupForm.studentSignup(request);
		
		doGet(request, response);
	}

}

