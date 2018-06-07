package edu.ucam.dao;

import java.util.ArrayList;

import edu.ucam.beans.User;

public interface UserDAO {
	public ArrayList<User> getAll();
	public User getById(String id);
}
