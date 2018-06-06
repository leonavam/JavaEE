package edu.ucam.servelts;

import java.io.IOException;

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
		
		if("admin".equals(name) && "1234".equals(pass)){
			System.out.println("Usuario correcto");
			User user = new User(name,pass);
			request.getSession().setAttribute("USER", user);
			
			this.getServletContext().getRequestDispatcher("/pagina.jsp").forward(request, response);
		}else{
			System.out.println("Usuario incorrecto");
		}
		
		
	}

}
