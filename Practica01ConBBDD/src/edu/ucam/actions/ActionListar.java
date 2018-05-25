package edu.ucam.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionListar extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "/secured/listar.jsp";
	}

}
