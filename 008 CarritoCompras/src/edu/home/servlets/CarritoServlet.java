package edu.home.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		String newProduct = request.getParameter("PRODUCTO");
		
		ArrayList<String> articulos = (ArrayList<String>) request.getSession().getAttribute("PRODUCTOS");
		
		if (articulos == null) {
			articulos = new ArrayList<>();
			request.getSession().setAttribute("PRODUCTOS", articulos);
		}
		
		if (newProduct != null && !newProduct.trim().equals("")) {
			articulos.add(newProduct);
		}
		
		PrintWriter out = response.getWriter();
		
		for (String producto : articulos) {
			out.println("<li>" + producto + "</li>");
		}
		
		out.println("<br>");
		out.println("<a href=\"index.html\">Regresar</a>");
		
		
	}

}
