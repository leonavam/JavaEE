package edu.home.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import edu.home.beans.Producto;
import edu.home.modelo.ModeloProductos;

/**
 * Servlet implementation class ServletProductos
 */
@WebServlet({ "/ServletProductos", "/Productos" })
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ModeloProductos mProductos;
	
	@Resource(name="jdbcPoolProductos")
	private DataSource pool;
		
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			mProductos = new ModeloProductos(pool);
		}catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<Producto> productos = mProductos.getProductos();
			
			request.setAttribute("PRODUCTOS", productos);
			
			request.getRequestDispatcher("/ListarProductos.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
