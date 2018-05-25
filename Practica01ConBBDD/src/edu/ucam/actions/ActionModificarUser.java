package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.Curso;
import edu.ucam.beans.User;
import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;

public class ActionModificarUser extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		String rol = request.getParameter("ROL");
		String update = request.getParameter("UPDATEOK");
		String jsp = null;

		Factory factory = Factory.getTypeFactory(Factory.MYSQL);
		UserDAO userDAO = factory.getUserDAO();

		Hashtable<String, User> users = userDAO.selectUser();
		request.getServletContext().setAttribute("USERS", users);
		User user = users.get(name);

		if (update == null) {
			request.setAttribute("ID", user.getId());
			request.setAttribute("UPNAME", user.getName());
			jsp = "/secured/update.jsp";

		} else {
			int id = Integer.parseInt(request.getParameter("ID"));
			System.out.println("\tlectura de id: " + id);
			User upUser = new User(id, name, pass, rol);
			((Hashtable<String, User>) request.getServletContext().getAttribute("USERS")).put(name, upUser);

			userDAO.updatetUser(upUser);

			jsp = "/secured/listar.jsp";
		}

		return jsp;

	}

}
