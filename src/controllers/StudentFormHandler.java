package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Student;
import dao.DAOStudent;

public class StudentFormHandler {
	
	private DAOStudent daoStudent;

	public StudentFormHandler(DAOStudent daoStudent) {
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
	
	
	public Student studentEdit(HttpServletRequest request, HttpServletResponse response) {
		Student student = new Student();
		
		System.out.println("id" + getValueFromRequest(request, "id"));
		
		String id = getValueFromRequest(request, "id");
		String firstName = getValueFromRequest(request, "firt_name");
		String lastName = getValueFromRequest(request, "last_name");
		String address = getValueFromRequest(request, "address");
		String level = getValueFromRequest(request, "level");
		
		try {
			if (!id.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() && !level.isEmpty()) {
				
				student.setId(Integer.parseInt(id));
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setAddress(address);
				student.setLevel(level);

				try {
					
					daoStudent.edit(student);
					
					System.out.println("StudentSignupForm.studentEdit(): values has been edited!");
					
				} catch (RuntimeException error) {
					System.out.println("StudentSignupForm.studentEdit() try edit: error!" + error);
				}
				
			}
			
		} catch (Exception error) {

			System.out.println("StudentSignupForm.studentEdit(): Empty values!");

			System.out.println(error);
			
			return null;
			
		}
		
		
		return student;
	}
	
	public boolean delete (HttpServletRequest request, HttpServletResponse response) {
		String id = getValueFromRequest(request, "id");
		
		try {
			if (!id.isEmpty()) {

				try {
										
					return daoStudent.delete(id);
					
				} catch (RuntimeException error) {
					System.out.println("StudentSignupForm.studentEdit() try delete: error!" + error);
					return false;
				}
				
			}
			
		} catch (Exception error) {

			System.out.println("StudentSignupForm.studentEdit(): Empty values!");

			System.out.println(error);
			
			return false;
		}
		return false;
		
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
