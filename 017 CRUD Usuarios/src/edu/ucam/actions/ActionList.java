package edu.ucam.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionList implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "/WEB-INF/listar.jsp";
	}

}
