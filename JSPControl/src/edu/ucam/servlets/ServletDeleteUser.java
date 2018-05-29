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
 * Servlet implementation class ServletDeleteUser
 */
@WebServlet("/ServletDeleteUser")
public class ServletDeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperamos los valores del usuario a dar de alta
		String name = request.getParameter("NAME");
		
		//Intentamos recuperar el usuario para comprobar si ya existe.
		User user = ((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).get(name);
		
		//Si no es null se debe a que el usuario ya existe. Enviamos mensaje a la JSP.
		if(user !=null){
			((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).remove(name);
			
		}else{
			System.out.println("No existe");
		}
		
		//Reenviamos la petición a la JSP.
		this.getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);
				
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
