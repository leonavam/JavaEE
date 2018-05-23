package edu.ucam.actions;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;

public class ActionAddCurso extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String nameCurso = request.getParameter("NAMECURSO");
		double creditos = Double.parseDouble(request.getParameter("CREDITOS"));
		String profesor = request.getParameter("PROFESOR");

		
		Hashtable<String, Curso> cursos = (Hashtable<String, Curso>) request.getServletContext().getAttribute("CURSOS");
		
		Curso curso = new Curso();
		curso.setNombreCurso(nameCurso);
		curso.setCreditos(creditos);
		curso.setProfesor(profesor);
		
		if (cursos == null) {
			cursos = new Hashtable<String, Curso>();
			cursos.put(nameCurso, curso);
			request.setAttribute("MSGc", "Tabla creada y añadido Curso");
			
		} else {
			cursos.put(nameCurso, curso);
			request.setAttribute("MSGc", "Curso añadido!");
		}
		
		Enumeration e = cursos.keys();
		Object clave;
		while( e.hasMoreElements() ){
			  clave = e.nextElement();
			  System.out.println( "Clave : " + clave );
			}
		
		
		request.getServletContext().setAttribute("CURSOS", cursos);
		
		return "/index.jsp";
	}

}
