package edu.ucam.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import edu.ucam.beans.Curso;
import edu.ucam.beans.User;
import edu.ucam.dao.CursoDAO;
import edu.ucam.dao.UserDAO;
import edu.ucam.dao.mysql.MyConnectionSQL;

public class CursoDaoImpl implements CursoDAO {

	// Para crear la conexion
	Connection myConn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// Sentencias SQL Usuarios
	private final String SQL_SELECT = "SELECT * FROM cursos";
	private final String SQL_INSERT = "INSERT INTO cursos(nombreCurso, creditos, profesor) VALUES(?,?,?)";
	private final String SQL_UPDATE = "UPDATE cursos SET nombreCurso=?, creditos=?, profesor=? WHERE idcursos=?";
	private final String SQL_DELETE = "DELETE FROM cursos WHERE idcursos= ?";

	@Override
	public int insert(Curso curso) {
		int rows = 0;

		try {
			myConn = MyConnectionSQL.getConection();
			ps = myConn.prepareStatement(SQL_INSERT);
			ps.setString(1, curso.getNombreCurso());
			ps.setDouble(2, curso.getCreditos());
			ps.setString(3, curso.getProfesor());

			rows = ps.executeUpdate();
			System.out.println("Se ha insertado " + rows + " filas");
		} catch (SQLException e) {
			System.out.println("Fallo con la sentencia: " + SQL_INSERT);
			e.printStackTrace();
		} finally {
			MyConnectionSQL.close(ps);
			MyConnectionSQL.close(myConn);
		}

		return rows;
	}

	@Override
	public int updatet(Curso curso) {
		int rows = 0;
		try {
			myConn = MyConnectionSQL.getConection();
			ps = myConn.prepareStatement(SQL_UPDATE);
			ps.setString(1, curso.getNombreCurso());
			ps.setDouble(2, curso.getCreditos());
			ps.setString(3, curso.getProfesor());
			ps.setInt(4, curso.getIdCurso());
			System.out.println(curso.getNombreCurso() + curso.getIdCurso() + curso.getCreditos() + curso.getProfesor());
			rows = ps.executeUpdate();
			System.out.println("Se ha actualizado " + rows + " registros");

		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia " + SQL_UPDATE);
			e.printStackTrace();
		} finally {
			MyConnectionSQL.close(ps);
			MyConnectionSQL.close(myConn);
		}

		return 0;
	}

	@Override
	public int delete(Curso curso) {
		int rows = 0;

		try {
			myConn = MyConnectionSQL.getConection();
			ps = myConn.prepareStatement(SQL_DELETE);
			ps.setInt(1, curso.getIdCurso());

			rows = ps.executeUpdate();
			System.out.println("Se ha borrado " + rows + " registros");

		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia: " + SQL_DELETE);
			e.printStackTrace();
		} finally {
			MyConnectionSQL.close(ps);
			MyConnectionSQL.close(myConn);
		}

		return rows;
	}

	@Override
	public Hashtable<String, Curso> select() {

		Hashtable<String, Curso> cursos = new Hashtable<>();
		try {
			myConn = MyConnectionSQL.getConection();
			ps = myConn.prepareStatement(SQL_SELECT);
			rs = ps.executeQuery();

			Curso curso = null;
			while (rs.next()) {
				curso = new Curso();
				curso.setIdCurso(rs.getInt(1));
				curso.setNombreCurso(rs.getString(2));
				curso.setCreditos(rs.getDouble(3));
				curso.setProfesor(rs.getString(4));

				cursos.put(curso.getNombreCurso(), curso);
			}

		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia: " + SQL_SELECT);
			e.printStackTrace();

		} finally {
			MyConnectionSQL.close(rs);
			MyConnectionSQL.close(ps);
			MyConnectionSQL.close(myConn);
		}

		return cursos;
	}

}
