package dao;

import beans.User;

public interface DAOUser {
	
	public void create(User user);
	
	public User getUser();
	
	public User signin(String email, String password);
	
}
