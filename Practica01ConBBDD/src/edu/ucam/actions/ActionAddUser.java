package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;
import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;

public class ActionAddUser extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// Recuperamos los valores del usuario a dar de alta
		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		String rol = request.getParameter("ROL");

		// Para conexión con BBDD
		Factory factory = null;
		UserDAO userDAO = null;

		// Intentamos recuperar el usuario para comprobar si ya existe.
		User user = ((Hashtable<String, User>) request.getServletContext().getAttribute("USERS")).get(name);

		// Si no es null se debe a que el usuario ya existe. Enviamos mensaje a la JSP.
		if (user != null) {
			request.setAttribute("MSG", "El usuario existe");
		} else {
			// Si no es null de debe a que el usuario no existe. Creamos el objeto con los
			// valores
			// recuperados del formulario
			user = new User(name, pass, rol);

			// Guardamos el usuario en la tabla hash que hay en el contexto. Desde este
			// momento
			// el usuario ya puede hacer login.
			((Hashtable<String, User>) request.getServletContext().getAttribute("USERS")).put(name, user);

			factory = Factory.getTypeFactory(Factory.MYSQL);
			userDAO = factory.getUserDAO();
			userDAO.insertUser(user);
			// Enviamos mensaje a la JSP indicando que el usuario se ha creado.
			request.setAttribute("MSG", "Usuario creado");
		}

		return "/index.jsp";
	}

}
