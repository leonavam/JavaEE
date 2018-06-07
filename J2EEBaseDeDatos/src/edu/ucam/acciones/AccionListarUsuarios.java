package edu.ucam.acciones;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;
import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;
import edu.ucam.servlets.Control;

public class AccionListarUsuarios extends Accion {

	public static final String NAME = "LOGIN";
	
	@Override
	public void ejecutar(HttpServletRequest request,
			HttpServletResponse response) {
		
		Factory factoria = Control.getFactory();
		UserDAO userDAO = factoria.getUserDAO();
		ArrayList<User> usuarios = userDAO.getAll();
		
		
		try {
			request.getRequestDispatcher("jsp/usuarios.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
