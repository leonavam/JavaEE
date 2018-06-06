package edu.ucam.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroServlet
 */

@WebFilter(filterName = "FiltroServlet", servletNames = { "ServletParaFiltrar" })
public class FiltroServlet implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroServlet() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Ejecutamos el filtro");
		
		if("1".equals(request.getParameter("LOGIN"))){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{	
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
