package edu.ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.beans.User;

/**
 * Servlet implementation class ServletDoLogin
 */
@WebServlet("/ServletLogin2")
public class ServletDoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Tabla con los usuarios que tienen acceso a la aplicación.
	
	
	       
    @Override
	public void init() throws ServletException {
    	//Buscamos la tabla de usuarios.
    	//Aunque sea la primera vez que se ejecuta este servlet puede darse el caso
    	//de que otro servlet la hubiera inicializado y guardado en el contexto con anterioridad
    	Hashtable<String, User> users = (Hashtable<String, User>) this.getServletContext().getAttribute("USERS");
		if (users == null){
			
			//Si no hay tabla la inicializamos
			System.out.print("Inicializando tabla... ");
			users = new Hashtable<String, User>();
			users.put("admin", new User("admin", "1234"));
			users.put("dad2", new User("dad2", "dad2"));
			users.put("ucam", new User("ucam", "ucam"));
			
			
			//Guardamos la tabla en el contexto.
			this.getServletContext().setAttribute("USERS", users);
			System.out.println("[OK]");
		}
		
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDoLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperamos parámetros para hacer login
		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		
		//Buscamos el usuario en la tabla de usuarios.
		User user = ((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).get(name);
		
		//Si existe y la clave es válida hacemos login guardando el objeto user en la sesión del usuario.
		if(user !=null){			
			if (user.getPass().equals(pass)){				
				request.getSession().setAttribute("USER_LOGGED", user);
			}else{				
				//Si no es correcta informamos al usuario mediante un mensaje en la JSP.
				request.setAttribute("MSG", "Usuario incorrecto");
			}
				
		}else{
			request.setAttribute("MSG", "Usuario no encontrado");
		}
		
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);		
		
	}

}
