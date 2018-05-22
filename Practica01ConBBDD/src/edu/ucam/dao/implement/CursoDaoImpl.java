package edu.ucam.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import edu.ucam.beans.Curso;
import edu.ucam.beans.User;
import edu.ucam.dao.CursoDAO;
import edu.ucam.dao.UserDAO;

public class CursoDaoImpl implements CursoDAO {
	
	//Para crear la conexion
	Connection myConn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	@Override
	public int insert(Curso curso) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updatet(Curso curso) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(Curso curso) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Hashtable<String, Curso> select() {
		// TODO Auto-generated method stub
		return null;
	}
	

	


}
