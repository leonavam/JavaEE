package edu.home.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//Definir el DataSource
	@Resource(name="jdbcPoolProductos")
	
	private DataSource pool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection myConnection = pool.getConnection();
			
			String sql = "SELECT * FROM PRODUCTOS";
			
			Statement statement = myConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			ArrayList<String> nombreArticulos = new ArrayList<>();
			
			while(rs.next()) {
				
				nombreArticulos.add(rs.getString(3));
				
			}
			request.getSession().setAttribute("ARTICULOS", nombreArticulos);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
