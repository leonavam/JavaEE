package edu.ucam.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.actions.Action;
import edu.ucam.actions.ActionListar;
import edu.ucam.actions.ActionLogin;
import edu.ucam.actions.ActionLogout;
import edu.ucam.beans.User;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
		if(actions == null){
			actions = new Hashtable<String,Action>();
			actions.put("LOGIN", new ActionLogin());
			actions.put("LOGOUT", new ActionLogout());
			actions.put("LISTAR", new ActionListar());
			
		}
		
		Hashtable<String, User> users = (Hashtable<String, User>) this.getServletContext().getAttribute("USERS");
		if (users == null){
			
			//Si no hay tabla la inicializamos
			System.out.print("Inicializando tabla... ");
			users = new Hashtable<String, User>();
			users.put("admin", new User("admin", "1234"));
			users.put("dad2", new User("dad2", "dad2"));
			users.put("ucam", new User("ucam", "ucam"));
			
			
			//Guardamos la tabla en el contexto.
			this.getServletContext().setAttribute("USERS", users);
			System.out.println("[OK]");
		}
		
		
		super.init();
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		//Reenviamos la petición a la JSP.
		this.getServletContext().getRequestDispatcher(jsp).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
