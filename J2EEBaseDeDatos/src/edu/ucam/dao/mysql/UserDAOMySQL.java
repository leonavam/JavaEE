package edu.ucam.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import edu.ucam.acciones.Accion;
import edu.ucam.beans.User;
import edu.ucam.dao.UserDAO;
import edu.ucam.servlets.Control;

public class UserDAOMySQL implements UserDAO {

	@Override
	public ArrayList<User> getAll() {
		ArrayList<User>resultado = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection con = Control.getDataSource().getConnection();
			ps = con.prepareStatement("SELECT * FROM USERS");
			rs = ps.executeQuery();		
			
			User user = null;
			while(rs.next()){								
				user = new User();
				user.setId(rs.getString("id"));
				user.setPass(rs.getString("pass"));
				
				resultado.add(user);
			}
			
		} catch (SQLException e) {
			System.out.println("Error: "+ e.toString());
		}  finally{
			try {
				if (rs != null)	rs.close();
				if (ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
