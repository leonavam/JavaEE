package edu.ucam.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccionLogout extends Accion {

	public static final String NAME = "LOGOUT";
	
	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("accion logout");
	}

}
