package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;

public class ActionListarCurso extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Hashtable<String, Curso> cursos = (Hashtable<String, Curso>) request.getServletContext().getAttribute("CURSOS");
		
		String jsp = "/index.jsp";
		
		if(cursos != null) {
			jsp = "/secured/listarCursos.jsp";
		}else {
			request.setAttribute("MSGc", "No existen Cursos para mostrar");
		}

		
		return jsp;
	}

}
