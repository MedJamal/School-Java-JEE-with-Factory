package dao;

import java.util.List;

import beans.Student;

public interface DAOStudent {

	// Create Student
	public void create(Student student);
	
	// Get Student
	public Student get(int id);
	
	// Get all Students as array list 
	public List<Student> getAll();

}
