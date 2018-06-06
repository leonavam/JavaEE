package edu.home.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	
		boolean newUser = true;
		int contador = 0;
		
		Cookie cookies[] = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				/*if (cookie.getName().equals("visitanteUsual") && cookie.getValue().equals("si")) {
					newUser = false;
					break;
				}*/
				if (cookie.getName().equals("contador")) {
					try {
						contador = Integer.parseInt(cookie.getValue());
					} catch (NumberFormatException e) {
						contador = 0;
					}
				}
			}
		}
		
		String msj = null;
		if (newUser) {
			Cookie visitante = new Cookie("visitanteUsual", "si");
			response.addCookie(visitante);
			msj = "Gracias por visitarnos";
		} else {
			msj = "Gracias por visitarnos nuevamente";
		}
		
		contador++;
		Cookie cont = new Cookie("contador", Integer.toString(contador));
		cont.setMaxAge(3600);
		response.addCookie(cont);
		
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println(msj);
		printWriter.println("Contador " + contador);
		
		printWriter.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
