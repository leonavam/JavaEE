package edu.ucam.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Accion {
	
	public synchronized void ejecutar(HttpServletRequest request, HttpServletResponse response) {
	}
	
}
