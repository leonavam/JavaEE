package edu.ucam.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import edu.ucam.beans.User;
import edu.ucam.dao.UserDAO;
import edu.ucam.dao.mysql.MyConnectionSQL;

public class UserDaoImpl implements UserDAO {
	
	//Para crear la conexion
	Connection myConn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//Sentencias SQL Usuarios
	private final String SQL_SELECT = "SELECT * FROM users";
	private final String SQL_INSERT = "INSERT INTO users(username, pass, rol) VALUES(?,?,?)";
	private final String SQL_UPDATE = "UPDATE users SET username=?, pass=?, rol=? WHERE IDUser=?";
	private final String SQL_DELETE = "DELETE FROM users WHERE IDUser= ?";
	
	@Override
	public int insertUser(User user) {
		int rows = 0;

		try {
			myConn = MyConnectionSQL.getConection(); // Obtiene la conexion con MySQL
			ps = myConn.prepareStatement(SQL_INSERT);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getRol());
			
			rows = ps.executeUpdate();
			System.out.println("Filas insertadas: " + rows);
		} catch (SQLException e) {
			System.out.println("Fallo BBDD");
			e.printStackTrace();
		} finally {
			MyConnectionSQL.close(ps);
			MyConnectionSQL.close(myConn);
		}

		return rows;
	}

	@Override
	public int updatetUser(User user) {
		int row = 0;
		
		try {
			
			myConn = MyConnectionSQL.getConection();
			ps = myConn.prepareStatement(SQL_UPDATE);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getRol());
			ps.setInt(4, user.getId());
			
			row = ps.executeUpdate();
			System.out.println("----->\t Filas actualizadas " + row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public int deleteUser(User user) {
		
		int row = 0;
		
		try {
			myConn = MyConnectionSQL.getConection();	//Obtiene la conexion con MySQL
			ps = myConn.prepareStatement(SQL_DELETE);
			ps.setInt(1, user.getId());
			
			row = ps.executeUpdate();
			
			System.out.println();
			
		} catch (SQLException e) {
			System.out.println("No se ha elimnado el usuario");
			e.printStackTrace();
		}
		
		return row;
	}

	@Override
	public Hashtable<String, User> selectUser() {
		//Tabla ha devolver en return
		Hashtable<String, User> users = new Hashtable<>();
		
		try {
			myConn = MyConnectionSQL.getConection();	//Obtiene la conexion con MySQL
			ps = myConn.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();
			
			User user = null;
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				users.put(rs.getString("USERNAME"), user);
			}
			
		} catch (SQLException e) {
			System.out.println("Fallo BBDD");
			e.printStackTrace();
		} finally {
			MyConnectionSQL.close(rs);
			MyConnectionSQL.close(ps);
			MyConnectionSQL.close(myConn);
		}

		return users;
	}


}
