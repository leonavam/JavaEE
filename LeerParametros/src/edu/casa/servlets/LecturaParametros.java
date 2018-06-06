package edu.casa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LecturaParametros
 */
@WebServlet("/LecturaParametros")
public class LecturaParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturaParametros() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		getServletContext().setAttribute("HORA_INICIO", new GregorianCalendar());
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre, apellido;
		String [] aficiones;
		
		apellido = request.getParameter("APELLIDO");
		nombre = request.getParameter("NAME");
		aficiones = request.getParameterValues("aficiones");
		
		//Recupera nombre de los parametros
		Enumeration parametros = request.getParameterNames();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet AtributosContext</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("");
			out.println("el primer arranque de este servlet se ha efectuado el ");
			out.println(((GregorianCalendar)getServletContext().getAttribute("HORA_INICIO")).getTime());
			out.println("<a href=\"parametrosAplicacion.jsp\">A la pagina JSP</a>");
			out.println("</body>");
			out.println("</html>");
			
		} finally {
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
