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
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String name = request.getParameter("NewNAME");
		String pass = request.getParameter("NewPASS");
		
		User user = ((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).get(name);
		
		if(user != null){
			request.setAttribute("MSG", "El usuario existe");
		} else {
			user = new User(name, pass);
			((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).put(name, new User(name, pass));
			request.setAttribute("MSG", "Usuario creado");
		}
		
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
