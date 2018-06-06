package edu.home.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.home.beans.Rectangulo;

/**
 * Servlet implementation class ServletControlador
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("ACCION");
		
		
		
		//Rectangulo rectangulo = new Rectangulo(5,2);
		
		
		
		Rectangulo rectanguloR = new Rectangulo(5, 2);
		Rectangulo rectanguloS = new Rectangulo(6, 3);
		Rectangulo rectanguloC = new Rectangulo(7, 4);
		
		if ("agregaVariables".equals(accion)) {
			request.setAttribute("rectanguloR", rectanguloR);
			request.getSession().setAttribute("rectanguloS", rectanguloS);
			this.getServletContext().setAttribute("rectanguloC", rectanguloC);
			request.setAttribute("msj", "Variables han sido agregadas");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if ("listarVariables".equals(accion)) {
			
			request.getRequestDispatcher("/WEB-INF/alcanceVariables.jsp").forward(request, response);
		}else {
			request.setAttribute("msj", "Acción no encontrada");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		request.getRequestDispatcher("vista/desplegarVariables.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
