package edu.ucam.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionLogout extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		request.getSession().removeAttribute("USER_LOGGED");
		System.out.println("saliste");
		return "/index.jsp";
	}

}
