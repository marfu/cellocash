package com.cellocash.security.dao;


import com.cellocash.security.service.entity.User;
import java.util.List;


public interface IMySQLUserDAO {
	
	public User createOrUpdateUser(User u);
	
	public User getUser(String userName);
	
	public boolean removeUser(User u);
	
	public List<User> getAllUsers();
	
	public User getUserByNameAndPassword(String userName,String password);

}
