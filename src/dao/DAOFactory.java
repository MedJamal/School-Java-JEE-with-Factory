package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sun.security.jca.GetInstance.Instance;

public class DAOFactory {
	
	private String url;
	private String username;
	private String password;
	
	private static DAOFactory instance = null;
	
	public DAOFactory (String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DAOFactory getInstance() {

		if (instance == null) {
			
			// Load JDBC driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// Later add method for error handler!
				System.out.println("Driver not found!");
				e.printStackTrace();
			}
			
			// Return the instance of this class: DAOFactory
	//		DAOFactory instance;
	//		return instance = new DAOFactory("jdbc:mysql://localhost:3306/school", "root", "");
			
			// singleton

			return instance = new DAOFactory("jdbc:mysql://localhost:3306/school", "root", "");
		}
		return instance;
		
	}
	
	// Create connection to the db.
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public DAOStudentImpl getDAOStudent() {
		return new DAOStudentImpl(this);
	}
	public DAOUserImpl getDAOUser() {
		return new DAOUserImpl(this);
	}
	
}
