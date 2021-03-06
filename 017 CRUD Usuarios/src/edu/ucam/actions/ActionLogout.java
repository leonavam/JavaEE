package edu.ucam.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionLogout implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.getSession().removeAttribute("LOGGED");
		request.setAttribute("MSGOUT", "Hasta la próxima");
		return "/index.jsp";
	}

}
