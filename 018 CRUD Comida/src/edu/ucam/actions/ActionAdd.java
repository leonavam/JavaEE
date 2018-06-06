package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Alimento;

public class ActionAdd implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("ALIMENTO");
		int cant = Integer.parseInt(request.getParameter("CANT"));
		
		Alimento alimento = ((Hashtable<String, Alimento>)request.getServletContext().getAttribute("ALIMENTOS")).get(name);
		
		if (alimento == null) {
			((Hashtable<String, Alimento>)request.getServletContext().getAttribute("ALIMENTOS")).put(name, new Alimento(name, cant));
		}else {
			System.out.println("Alimento ya ha sido ingresado");
		}
		
		
		return "/index.jsp";
	}

}
