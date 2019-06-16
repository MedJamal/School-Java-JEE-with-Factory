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

@WebServlet("/student-delete")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOStudent daoStudent;

       
    public StudentDeleteServlet() {
        super();
    }
    
    public void init() {
    	System.out.println("INIT RUN");
    	this.daoStudent = ((DAOFactory)getServletContext().getAttribute("daofactory")).getDAOStudent();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HandleSession handleSession = new HandleSession(request);
		
		User user = handleSession.retriveUser();
		
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/signin");
		} else {
			System.out.println("POST RUN: /DeleteStudents");
			
			StudentFormHandler studentForm = new StudentFormHandler(daoStudent);
			
			// Check if values are !empty
			if (!(studentForm.delete(request, response) == false)) {
				
				// replace with session messages for success !!!!
				System.out.println("SERVLET do POST: Confirm values has been deleted!");
				
				handleSession.alertSuccess("Student has been deleted successfully!");
				
			} else {
				System.out.println("SERVLET do POST: Empty values from request");
			}
			
			response.sendRedirect(request.getHeader("referer"));
		}
		
	}

}
