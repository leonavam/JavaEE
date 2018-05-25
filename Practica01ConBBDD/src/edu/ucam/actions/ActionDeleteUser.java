package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;
import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;

public class ActionDeleteUser extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// Recuperamos los valores del usuario a dar de alta
		String name = request.getParameter("NAME");
		Factory factory = Factory.getTypeFactory(Factory.MYSQL);
		UserDAO userDAO = factory.getUserDAO();

		// Intentamos recuperar el usuario para comprobar si ya existe.
		User user = ((Hashtable<String, User>) request.getServletContext().getAttribute("USERS")).get(name);

		// Si no es null se debe a que el usuario ya existe. Enviamos mensaje a la JSP.
		if (user != null) {
			userDAO.deleteUser(user);
			((Hashtable<String, User>) request.getServletContext().getAttribute("USERS")).remove(name);

		} else {
			System.out.println("No existe el usuario");
		}

		return "/secured/listar.jsp";
	}

}
