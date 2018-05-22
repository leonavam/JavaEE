package edu.ucam.actions;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;
import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;

public class ActionLogin extends Action {

	Factory factory = null;
	UserDAO userDAO = null;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		//Cada que hay un login se carga la base de datos
		factory = Factory.getTypeFactory(Factory.MYSQL);
		userDAO = factory.getUserDAO();
		Hashtable<String, User> users = (Hashtable<String, User>) request.getServletContext().getAttribute("USERS");
		if (users == null){
			//Si no hay tabla la inicializamos
			System.out.println("Inicializando tabla... ");
		
			users = new Hashtable<String, User>();
			users = userDAO.selectUser();
			
			//Guardamos la tabla en el contexto.
			request.getServletContext().setAttribute("USERS", users);
			System.out.println("[OK]");
		}
		
		
		//Recuperamos par�metros para hacer login
		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		
		//Buscamos el usuario en la tabla de usuarios.
		User user = ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS")).get(name);
		
		//Si existe y la clave es v�lida hacemos login guardando el objeto user en la sesi�n del usuario.
		if(user != null){			
			if (user.getPass().equals(pass)){				
				request.getSession().setAttribute("USER_LOGGED", user);
				request.getSession().setAttribute("ROL", user.getRol());
			}else{				
				//Si no es correcta informamos al usuario mediante un mensaje en la JSP.
				request.setAttribute("MSG", "Usuario incorrecto");
			}
				
		}else{
			request.setAttribute("MSG", "Usuario no encontrado");
		}
		return "/index.jsp";
	}

}
