package edu.home.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = null, msj = null;
		String tipoNavegador = request.getHeader("user-agent");
		System.out.println(tipoNavegador);
		
		if (tipoNavegador != null) {

			if (tipoNavegador.contains("Trident")) {
				titulo = "Internet Explorer";
				msj = "Navegas en " + titulo;
			}else if (tipoNavegador.contains("Firefox")) {
				titulo = "Mozilla Firefox";
				msj = "Navegas en " + titulo;
			}else if (tipoNavegador.contains("Chrome")) {
				titulo = "Chrome";
				msj = "Navegas en " + titulo;
			}
		}
		
		request.setAttribute("Titulo", titulo);
		request.setAttribute("Msj", msj);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
