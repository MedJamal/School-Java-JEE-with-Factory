package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import dao.DAOStudent;

public class StudentSignupForm {
	
	private DAOStudent daoStudent;

	public StudentSignupForm(DAOStudent daoStudent) {
		this.daoStudent = daoStudent;
	}
	
	public Student studentSignup(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Student student = new Student();
		
		String firstName = getValueFromRequest(request, "firt_name");
		String lastName = getValueFromRequest(request, "last_name");
		String address = getValueFromRequest(request, "address");
		String level = getValueFromRequest(request, "level");
		
		try {
			if (!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !level.isEmpty()) {
				
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setAddress(address);
				student.setLevel(level);

				try {
					
					daoStudent.create(student);
					
					System.out.println("StudentSignupForm.studentSignup(): values has been added!");
					
				} catch (RuntimeException error) {
					System.out.println("StudentSignupForm.studentSignup() try create: error!" + error);
				}
				
			}
			
		} catch (Exception error) {

			System.out.println("StudentSignupForm.studentSignup(): Empty values!");

			System.out.println(error);
			
			return null;
			
		}
		
		
		return student;
		
	}
	
	
	private String getValueFromRequest(HttpServletRequest request, String faildName) {
		
		String value = request.getParameter(faildName);
		
		if (value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value;
		}
		
	}
	
}
