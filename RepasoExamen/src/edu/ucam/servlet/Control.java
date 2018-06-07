package edu.ucam.servlet;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ucam.actions.*;
import edu.ucam.beans.User;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	Hashtable<String, Action> actions;
	Hashtable<String, User> users;
	
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
		
		
		actions = new Hashtable<>();
		actions.put("LOGIN", new ActionLogin());
		
		
		users = new Hashtable<>();
		users.put("admin", new User("admin", "1234"));
		
		this.getServletContext().setAttribute("USERS", users);
		
		
		super.init();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionID = (String) request.getParameter("ACTION_ID");
		
		String jsp = "/index.jsp";
		
		if (actionID != null) {
			Action action = this.actions.get(actionID);
			jsp = action.execute(request, response);
		}
		
		this.getServletContext().getRequestDispatcher(jsp).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
