package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Alimento;

public class ActionDelete implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("BORRAR");
		
		Alimento alimento = ((Hashtable<String, Alimento>)request.getServletContext().getAttribute("ALIMENTOS")).get(name);
		
		if (alimento != null) {
			((Hashtable<String, Alimento>)request.getServletContext().getAttribute("ALIMENTOS")).remove(name);
		}else {
			System.out.println("Alimento no encontrado");
		}
		return "listar.jsp";
	}

}
