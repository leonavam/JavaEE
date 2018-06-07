package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;

public class ActionLogin extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		
		User user = ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS")).get(name);
		System.out.println(user.getName() + " " + user.getPass());
		request.getSession().setAttribute("LOGGED", user);
		
		return "/index.jsp";
	}

}
