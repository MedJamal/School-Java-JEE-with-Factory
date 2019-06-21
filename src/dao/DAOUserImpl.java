package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import beans.User;
import session.HandleSession;

public class DAOUserImpl implements DAOUser {
	
	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	
	private DAOFactory daoFactory;
	
	// Initialise DAOFactory
	public DAOUserImpl (DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void create(User user) {
		try {
			
			this.connection = daoFactory.getConnection();
			
			this.preparedStatement = connection.prepareStatement("INSERT INTO users (name, email, password, created_at) VALUES (?, ?, ?, NOW())");
			
			this.preparedStatement.setString(1, user.getName());
			this.preparedStatement.setString(2, user.getEmail());
			this.preparedStatement.setString(3, user.getPassword());
			
			this.preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public User getUser() {
		return null;
	}

	@Override
	public User signin(String email, String password) {
		
		try {
			this.connection = daoFactory.getConnection();
			this.statement = this.connection.createStatement();
			
			this.resultSet = this.statement.executeQuery("SELECT id, name, email FROM users WHERE email='" + email + "' AND password='" + password + "'");
			
			User user = new User();
			
			if(resultSet.next()) {
				 user.setId(resultSet.getInt(1));
				 user.setName(resultSet.getString(2));
				 user.setEmail(resultSet.getString(3));
			} else {
				
				System.out.println("Email or password are not correct");
				
				HttpServletRequest request = null ;
				HandleSession handleSession = new HandleSession(request);
				handleSession.alertDanger("Email or password are not correct");
				
				return null;
			}
			
			System.out.println("User ID is :" + user.getId());
			
			return user;
			
		} catch (SQLException e) {
			System.out.println("Error: Auth problem");
			
			HttpServletRequest request = null ;
			HandleSession handleSession = new HandleSession(request);
			handleSession.alertDanger("Error: Authenctication problem");
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			return null;
		}

		
	}

}
