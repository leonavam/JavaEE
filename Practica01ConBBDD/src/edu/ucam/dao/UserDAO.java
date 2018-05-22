package edu.ucam.dao;

import java.util.Hashtable;

import edu.ucam.beans.User;

public interface UserDAO {

	public int insertUser(User user);
	public int updatetUser(User user);
	public int deleteUser(User user);
	public Hashtable<String, User> selectUser();
	
}
