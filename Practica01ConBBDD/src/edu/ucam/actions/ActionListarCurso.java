package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;
import edu.ucam.dao.CursoDAO;
import edu.ucam.dao.Factory;

public class ActionListarCurso extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		Factory factory = Factory.getTypeFactory(Factory.MYSQL);
		CursoDAO cursoDAO = factory.getCursoDAO();

		Hashtable<String, Curso> cursos = cursoDAO.select();
		request.getServletContext().setAttribute("CURSOS", cursos);
		
		String jsp = "/index.jsp";

		if (cursos != null) {
			jsp = "/secured/listarCursos.jsp";
		} else {
			request.setAttribute("MSGc", "No existen Cursos para mostrar");
		}

		return jsp;
	}

}
