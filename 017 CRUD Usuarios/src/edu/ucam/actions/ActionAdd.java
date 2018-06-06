package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;

public class ActionAdd implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String usuario = request.getParameter("USER");
		String pass = request.getParameter("PASS");
		
		User user = ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS")).get(usuario);
		
		if (user != null) {
			request.setAttribute("MSG", "El usuario existe, inténtalo con otros valores!");
		} else {
			
			user = new User(usuario, pass);
			
			((Hashtable<String, User>)request.getServletContext().getAttribute("USERS")).put(usuario, user);
			
			request.setAttribute("MSG", "Usuario creado");
		}
		
		return "/index.jsp";
	}

}
