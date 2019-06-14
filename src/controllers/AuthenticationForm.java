package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.DAOUser;
import session.HandleSession;

public class AuthenticationForm {
	
	private DAOUser daoUser;

	public AuthenticationForm(DAOUser daoUser) {
		this.daoUser = daoUser;
	}
	
	public User signup(HttpServletRequest request, HttpServletResponse response) {
		
		User user = new User();
		
		String name = getValueFromRequest(request, "name");
		String email = getValueFromRequest(request, "email");
		String password = getValueFromRequest(request, "password");
		String passwordConfirmation = getValueFromRequest(request, "password_confirmation");
		
		try {
			if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !passwordConfirmation.isEmpty()) {
				
				if (!this.passwordConfirnation(password, passwordConfirmation)) {
					// create session for errors
					System.out.println("Password does't match");
					
					HandleSession handleSession = new HandleSession(request);
					
					handleSession.alertWarning("Email or password does't match");
					return null;
				}
				
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				
				try {
					
					daoUser.create(user);
					
					System.out.println("User SignupForm.Signup(): user has been added!");
					HandleSession handleSession = new HandleSession(request);
					
					handleSession.alertSuccess("Your account created successfully");
					
				} catch (RuntimeException error) {
					System.out.println("User SignupForm.Signup() try create: error!" + error);
				}
				
			}
			
		} catch (Exception error) {

			System.out.println("User SignupForm.Signup(): Empty values!");

			System.out.println(error);
			
			HandleSession handleSession = new HandleSession(request);
			
			handleSession.alertWarning("Empty values, are faild are requered!");
			
			return null;
			
		}
		
		return user;
		
	}
	
	public User signin(HttpServletRequest request, HttpServletResponse response) {
		String email = getValueFromRequest(request, "email");
		String password = getValueFromRequest(request, "password");
		
		try {
			if (!email.isEmpty() && !password.isEmpty()) {
				
				try {
					
					return daoUser.signin(email, password);
					
				} catch (RuntimeException error) {
					System.out.println("AuthenticationForm class : Error signin");
					
					HandleSession handleSession = new HandleSession(request);
					handleSession.alertDanger("Error 3306");
					
					return null;
				}
				
			}
			
		} catch (Exception error) {
			System.out.println("AuthenticationForm class : signin Error");
			System.out.println(error.getMessage());
			System.out.println(error);
			HandleSession handleSession = new HandleSession(request);
			
			handleSession.alertDanger("Error");
			return null;
		}
		return null;
		
	}
	
	private boolean passwordConfirnation(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation) ? true : false;
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
