package edu.ucam.actions;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;
import edu.ucam.dao.CursoDAO;
import edu.ucam.dao.Factory;

public class ActionAddCurso extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String nameCurso = request.getParameter("NAMECURSO");
		double creditos = Double.parseDouble(request.getParameter("CREDITOS"));
		String profesor = request.getParameter("PROFESOR");

		// Para la BBDD
		Factory factory = Factory.getTypeFactory(Factory.MYSQL);
		CursoDAO cDao = factory.getCursoDAO();

		Hashtable<String, Curso> cursos = (Hashtable<String, Curso>) request.getServletContext().getAttribute("CURSOS");

		Curso curso = new Curso();
		curso.setNombreCurso(nameCurso);
		curso.setCreditos(creditos);
		curso.setProfesor(profesor);

		if (cursos == null) {
			cursos = new Hashtable<String, Curso>();
			cursos.put(nameCurso, curso);
		} else {
			cursos.put(nameCurso, curso);
		}
		request.setAttribute("MSGc", "Curso añadido!");
		// Añade el curso a la BBDD
		cDao.insert(curso);

		request.getServletContext().setAttribute("CURSOS", cursos);

		return "/index.jsp";
	}

}
