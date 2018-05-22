package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;

public class ActionModificarCurso extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String nameCurso = request.getParameter("NAMECURSO");
		String profesor = request.getParameter("PROFESOR");
		String update = request.getParameter("UPDATEOK");
		String jsp = null;
		
		System.out.println("pasamos las lecturas!!!!");
		Hashtable<String, Curso> cursos = (Hashtable<String, Curso>) request.getServletContext().getAttribute("CURSOS");
		Curso curso = cursos.get(nameCurso);
		
		if(update == null) {
			request.setAttribute("UPNAME", curso.getNombreCurso());
			jsp = "/secured/updateCursos.jsp";
			
		}else {
			double creditos = Double.parseDouble(request.getParameter("CREDITOS"));
			
			Curso upCurso = new Curso();
			upCurso.setNombreCurso(nameCurso);
			upCurso.setCreditos(creditos);
			upCurso.setProfesor(profesor);
			
			cursos.put(nameCurso, upCurso);

			jsp = "/secured/listarCursos.jsp";
		}
		
		
		return jsp;
		
		
	}

}
