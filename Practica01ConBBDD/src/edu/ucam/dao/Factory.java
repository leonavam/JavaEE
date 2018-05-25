package edu.ucam.dao;

import edu.ucam.factories.FactoryMySQL;

public abstract class Factory {

	// Tipo de conexion a utilizar
	public static final int MYSQL = 1;
	public static final int FILE = 2;

	public abstract UserDAO getUserDAO();

	public abstract ActionDAO getActionDAO();

	public abstract CursoDAO getCursoDAO();

	public static Factory getTypeFactory(int type) {

		switch (type) {
		case MYSQL:
			return new FactoryMySQL();
		case FILE:
			return null;
		}

		return null;
	}

}
