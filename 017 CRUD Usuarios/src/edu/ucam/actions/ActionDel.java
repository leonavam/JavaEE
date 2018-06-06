package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;

public class ActionDel implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("NAME");
		User user = ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS")).get(name);
		
		if (user != null) {
			
			((Hashtable<String, User>)request.getServletContext().getAttribute("USERS")).remove(name);
			//request.setAttribute("MSGDEL", "Usuario Eliminado!");
		} else {
			//request.setAttribute("MSGDEL", "El usuario no existe");
		}
		
		
		return "/WEB-INF/listar.jsp";
	}

}
