package edu.ucam.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccionNoEncontrada extends Accion {

	public static final String NAME = "NOACCION";
	
	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("accion no encontrada");
	}

}
