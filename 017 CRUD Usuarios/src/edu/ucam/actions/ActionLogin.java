package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;

public class ActionLogin implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String usuario = request.getParameter("USER");
		String pass = request.getParameter("PASS");
		
		User user = ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS")).get(usuario);
		if (user != null) {
			if (user.getPass().equals(pass)) {
				request.getSession().setAttribute("LOGGED", user);
				request.setAttribute("MSG", "Bienvenido " +user.getUser());
				System.out.println("LOGGED");
			}else {
				request.setAttribute("MSG", "Usuario incorrecto");
			}
		}else {
			request.setAttribute("MSG", "Usuario no encontrado");
		}
		
		return "/index.jsp";
	}

}
