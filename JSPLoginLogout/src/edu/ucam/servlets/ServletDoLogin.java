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
@WebServlet("/ServletLogin")
public class ServletDoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Hashtable<String, User> users;
	
       
    @Override
	public void init() throws ServletException {
		if (users == null){
			System.out.println("Inicializando tabla...");
			users = new Hashtable<String, User>();
			users.put("admin", new User("admin", "1234"));
			users.put("dad2", new User("dad2", "dad2"));
			users.put("ucam", new User("ucam", "ucam"));
			
			this.getServletContext().setAttribute("USERS", users);
		}
		
		System.out.println("Tabla inicializada");
		super.init();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDoLogin() {
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
		String name = request.getParameter("NAME");
		String pass = request.getParameter("PASS");
		
		User user = ((Hashtable<String, User>)this.getServletContext().getAttribute("USERS")).get(name);
		
		if(user !=null){			
			if (user.getPass().equals(pass)){				
				request.getSession().setAttribute("USER_LOGGED", user);
			}else{				
				request.setAttribute("MSG", "Usuario incorrecto");
			}
				
		}else{
			request.setAttribute("MSG", "Usuario no encontrado");
		}
		
		
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

}
