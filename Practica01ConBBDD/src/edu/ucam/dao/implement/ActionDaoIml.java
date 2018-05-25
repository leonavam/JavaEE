package edu.ucam.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import edu.ucam.actions.Action;
import edu.ucam.beans.User;
import edu.ucam.dao.ActionDAO;
import edu.ucam.dao.UserDAO;
import edu.ucam.dao.mysql.MyConnectionSQL;

public class ActionDaoIml implements ActionDAO {

	// Para crear la conexion
	Connection myConn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// Sentencias SQL Usuarios
	private final String SQL_SELECT = "SELECT * FROM actions";

	@Override
	public Hashtable<String, Action> loadActions() {

		// Tabla ha devolver en return
		Hashtable<String, Action> actions = new Hashtable<>();

		try {
			myConn = MyConnectionSQL.getConection(); // Obtiene la conexion con MySQL
			ps = myConn.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();

			Action action = null;
			String id = null;
			while (rs.next()) {
				action = (Action) Class.forName(rs.getString(2)).newInstance();
				id = rs.getString(1);
				System.out.println("add: " + id + " " + action);
				actions.put(id.toUpperCase(), action);
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL: " + e.toString());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			MyConnectionSQL.close(rs);
			MyConnectionSQL.close(ps);
			MyConnectionSQL.close(myConn);
		}

		System.out.println("Lectura Actions OK");

		return actions;
	}

}
