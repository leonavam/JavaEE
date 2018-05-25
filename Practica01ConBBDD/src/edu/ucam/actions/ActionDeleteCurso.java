package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;
import edu.ucam.dao.CursoDAO;
import edu.ucam.dao.Factory;

public class ActionDeleteCurso extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("NAME");
		Curso curso = ((Hashtable<String, Curso>) request.getServletContext().getAttribute("CURSOS")).get(name);

		Factory factory = Factory.getTypeFactory(Factory.MYSQL);
		CursoDAO cDao = factory.getCursoDAO();

		if (curso != null) {
			cDao.delete(curso);
			((Hashtable<String, Curso>) request.getServletContext().getAttribute("CURSOS")).remove(name);
		} else {
			request.setAttribute("MSG", "No existe el curso a eliminar");
		}

		return "/secured/listarCursos.jsp";
	}

}
