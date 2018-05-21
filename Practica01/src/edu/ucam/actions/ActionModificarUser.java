package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;
import edu.ucam.beans.User;

public class ActionModificarUser extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		String rol = request.getParameter("ROL");
		String update = request.getParameter("UPDATEOK");
		String jsp = null;
		
		Hashtable<String, User> users = (Hashtable<String, User>) request.getServletContext().getAttribute("USERS");
		User user = users.get(name);
		
		if(update == null) {
			request.setAttribute("UPNAME", user.getName());
			jsp = "/secured/update.jsp";
			
		}else {
			User upUser = new User(name, pass, rol);
			users.put(name, upUser);
			jsp = "/secured/listar.jsp";
		}
		
		
		return jsp;
		
		
	}

}
