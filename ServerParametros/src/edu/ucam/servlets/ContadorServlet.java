package edu.ucam.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContadorServlet
 */
@WebServlet("/Contador")
public class ContadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int contador;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Cargando servlet");
		contador = 1;
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Esto es todo...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resetParam = request.getParameter("RESET");  	//entre las comillas el nombre del parametro
		String nameParam = request.getParameter("name");
		String claseParam = request.getParameter("clase");
		
		
		Integer contadorSesion = (Integer)request.getSession().getAttribute("CONTADOR");
		if(contadorSesion == null){
			contadorSesion = new Integer(0);
			
		}
		
		
		int i = contadorSesion.intValue();
		contadorSesion = new Integer(++i);
		request.getSession().setAttribute("CONTADOR", contadorSesion);
		
		
		
		if("1".equals(resetParam)){
			contador = 0;
		}
		
		response.setContentType("text/html");
		
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<html>");
		out.println("<head><title>Hello World</title></head>");
		out.println("<body>");
		out.println("<h1>Hello " + nameParam + "</h1>Es la ejecución número: " + contador++ + " del servlet, la número " + i + " del usuario");
		out.println("-->" );
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
