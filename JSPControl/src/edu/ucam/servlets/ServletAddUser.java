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
 * Servlet implementation class ServletAddUser
 */
@WebServlet("/ServletAddUser")
public class ServletAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperamos los valores del usuario a dar de alta
		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		
		//Intentamos recuperar el usuario para comprobar si ya existe.
		User user = ((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).get(name);
		
		//Si no es null se debe a que el usuario ya existe. Enviamos mensaje a la JSP.
		if(user !=null){
			request.setAttribute("MSG", "El usuario existe");
		}else{
			//Si no es null de debe a que el usuario no existe. Creamos el objeto con los valores
			//recuperados del formulario
			user = new User(name,pass);
			
			//Guardamos el usuario en la tabla hash que hay en el contexto. Desde este momento
			//el usuario ya puede hacer login.
			((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).put(name,user);
			
			//Enviamos mensaje a la JSP indicando que el usuario se ha creado.
			request.setAttribute("MSG", "Usuario creado");
		}
		
		//Reenviamos la petición a la JSP.
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

}
