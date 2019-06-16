package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import beans.User;
import dao.DAOFactory;
import dao.DAOStudent;
import session.HandleSession;

@WebServlet("/edit-student")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOStudent daoStudent;

    public EditStudentServlet() {
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
			
			if (request.getParameter("id") == null) {
				response.sendRedirect(request.getHeader("referer"));
			} else {
				Student student = this.daoStudent.get(Integer.parseInt(request.getParameter("id")));
				
				request.setAttribute("student", student);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/student/edit.jsp").forward(request, response);
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HandleSession handleSession = new HandleSession(request);
		
		User user = handleSession.retriveUser();
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/signin");
		} else {
			System.out.println("POST RUN: /Editstudents");
			
			StudentFormHandler studentForm = new StudentFormHandler(daoStudent);
			
			// Check if values are !empty
			if (!(studentForm.studentEdit(request, response) == null)) {
				
				// replace with session messages for success !!!!
				System.out.println("SERVLET do POST: Confirm values has been edited!");
				
				handleSession.alertSuccess("Student has been edited successfully!");
				
			} else {
				System.out.println("SERVLET do POST: Empty values from request");
			}
			
			response.sendRedirect(request.getHeader("referer"));
		}
		
	}

}
