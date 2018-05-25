package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;
import edu.ucam.dao.CursoDAO;
import edu.ucam.dao.Factory;

public class ActionModificarCurso extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String nameCurso = request.getParameter("NAMECURSO");
		String profesor = request.getParameter("PROFESOR");
		String update = request.getParameter("UPDATEOK");
		String jsp = null;
		
		Factory factory = Factory.getTypeFactory(Factory.MYSQL);
		CursoDAO cursoDAO = factory.getCursoDAO();
		
		
		Hashtable<String, Curso> cursos = cursoDAO.select();
		
		if (cursos == null) {
			System.out.println("No hay datos en CURSOS");
		}
		
		request.getServletContext().setAttribute("CURSOS", cursos);
		Curso curso = cursos.get(nameCurso);
		
		
		if(update == null) {
			request.setAttribute("ID", curso.getIdCurso());
			request.setAttribute("UPNAME", curso.getNombreCurso());
			jsp = "/secured/updateCursos.jsp";
			
		}else {
			double creditos = Double.parseDouble(request.getParameter("CREDITOS"));
			int id = Integer.parseInt(request.getParameter("ID"));
			
			//Creamos un nuev objeto Curso para actualizar la tabla.
			Curso upCurso = new Curso();
			upCurso.setIdCurso(id);
			upCurso.setNombreCurso(nameCurso);
			upCurso.setCreditos(creditos);
			upCurso.setProfesor(profesor);
			
			((Hashtable<String, Curso>) request.getServletContext().getAttribute("CURSOS")).put(nameCurso, upCurso);
			
			cursoDAO.updatet(upCurso);

			jsp = "/secured/listarCursos.jsp";
		}
		
		
		return jsp;
		
		
	}

}
