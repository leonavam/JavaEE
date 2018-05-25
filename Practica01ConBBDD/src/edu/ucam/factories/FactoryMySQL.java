package edu.ucam.factories;

import edu.ucam.dao.ActionDAO;
import edu.ucam.dao.CursoDAO;
import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;
import edu.ucam.dao.implement.ActionDaoIml;
import edu.ucam.dao.implement.CursoDaoImpl;
import edu.ucam.dao.implement.UserDaoImpl;

public class FactoryMySQL extends Factory {

	@Override
	public UserDAO getUserDAO() {
		return new UserDaoImpl(); // Devulve la implementación de SQL
	}

	@Override
	public ActionDAO getActionDAO() {
		return new ActionDaoIml();
	}

	@Override
	public CursoDAO getCursoDAO() {
		return new CursoDaoImpl();
	}

}
