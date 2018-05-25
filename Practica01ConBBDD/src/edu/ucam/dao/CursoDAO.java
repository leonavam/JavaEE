package edu.ucam.dao;

import java.util.Hashtable;

import edu.ucam.beans.Curso;

public interface CursoDAO {

	public int insert(Curso curso);

	public int updatet(Curso curso);

	public int delete(Curso curso);

	public Hashtable<String, Curso> select();

}
