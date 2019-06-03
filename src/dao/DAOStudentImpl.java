package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Student;

public class DAOStudentImpl implements DAOStudent {

	private DAOFactory daoFactory;
	
	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	
	// Initialise DAOFactory
	public DAOStudentImpl (DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(Student student) {
		

		
		try {
			this.connection = daoFactory.getConnection();
			
			this.preparedStatement = connection.prepareStatement("INSERT INTO students (first_name, last_name, address, level, created_at) VALUES (?, ?, ?, ?, NOW())");
			
			this.preparedStatement.setString(1, student.getFirstName());
			this.preparedStatement.setString(2, student.getLastName());
			this.preparedStatement.setString(3, student.getAddress());
			this.preparedStatement.setString(4, student.getLevel());
			
			this.preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Student get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAll() {
		try {
			
			this.connection = daoFactory.getConnection();
			this.statement = this.connection.createStatement();
			
			this.resultSet = this.statement.executeQuery("SELECT * FROM students");
			ArrayList<Student> students = new ArrayList<Student>();
			
			while(resultSet.next()) {

				Student student = new Student();
				
				student.setId(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setAddress(resultSet.getString(4));
				student.setLevel(resultSet.getString(5));
				student.setCreatedAt(resultSet.getDate(6));
				
				students.add(student);

			}
			
			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	

}
