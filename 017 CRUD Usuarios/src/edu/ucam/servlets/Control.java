package edu.ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.actions.Action;
import edu.ucam.actions.ActionAdd;
import edu.ucam.actions.ActionDel;
import edu.ucam.actions.ActionList;
import edu.ucam.actions.ActionLogin;
import edu.ucam.actions.ActionLogout;
import edu.ucam.beans.User;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Hashtable<String, User> users;
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
		// TODO Auto-generated method stub
		super.init();
		
		if (users == null) {
			users = new Hashtable<>();
			users.put("admin", new User("admin", "1234"));
			users.put("leo", new User("leo", "leo"));
		}
		
		this.getServletContext().setAttribute("USERS", users);
		System.out.println("Usuarios cargados en Contexto");
		
		if (actions == null) {
			actions = new Hashtable<>();
			actions.put("LOGIN", new ActionLogin());
			actions.put("ADD", new ActionAdd());
			actions.put("LIST", new ActionList());
			actions.put("DEL", new ActionDel());
			actions.put("LOGOUT", new ActionLogout());
			
			
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String jsp = "/index.jsp";
		String actionId = request.getParameter("ACTION");
		
		if (actionId == null) {
			System.out.println("No se ha definido la acción");
		} else {
			System.out.println("Accion a ejecutar: " + actionId);
			Action action = this.actions.get(actionId);
			
			if (action == null) {
				System.out.println("La acción no está definida");
			} else {
				System.out.println("accion implrementada en " + action.toString());
				jsp = action.execute(request, response);
			}
		}
		
		
		this.getServletContext().getRequestDispatcher(jsp).forward(request, response);
	}

}
