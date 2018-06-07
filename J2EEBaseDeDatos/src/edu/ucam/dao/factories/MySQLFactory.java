package edu.ucam.dao.factories;

import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;
import edu.ucam.dao.mysql.UserDAOMySQL;

public class MySQLFactory implements Factory{

	@Override
	public UserDAO getUserDAO() {		
		return new UserDAOMySQL();
	}

}
