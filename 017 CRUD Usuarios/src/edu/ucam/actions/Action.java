package edu.ucam.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
	
}
