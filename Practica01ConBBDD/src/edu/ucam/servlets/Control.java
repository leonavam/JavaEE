package edu.ucam.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.actions.Action;
import edu.ucam.beans.User;
import edu.ucam.dao.ActionDAO;
import edu.ucam.dao.Factory;
import edu.ucam.dao.UserDAO;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Factory factory = null;
	ActionDAO actionDAO = null;
	private Hashtable<String, Action> actions;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	@Override
	public void init() throws ServletException {
		super.init();
		
		factory = Factory.getTypeFactory(Factory.MYSQL);
		//Carga las acciones al iniciar el servlet
		actionDAO = factory.getActionDAO();
		actions = actionDAO.loadActions();
		
		//Guarda los usuarios en el contexto
		
	}




	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionId = (String)request.getParameter("ACTION_ID");
		
		String jsp = "/index.jsp";
		
		if(actionId == null){
			System.out.println("No se ha definido acción a ejecutar");
		}else{
			System.out.println("Acción a ejecutar: " + actionId);
			Action action = this.actions.get(actionId);
			
			if(action == null){
				System.out.println("La acción no está definida");
			}else{
				System.out.println("Acción implementada en " + action.toString());
				jsp = action.execute(request, response);
			}
		}
		
		//Reenviamos la petici�n a la JSP.
		this.getServletContext().getRequestDispatcher(jsp).forward(request, response);
		
		
	}

}
