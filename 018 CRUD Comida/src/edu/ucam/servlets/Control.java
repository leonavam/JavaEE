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
import edu.ucam.actions.ActionDelete;
import edu.ucam.actions.ActionListar;
import edu.ucam.actions.ActionLogout;
import edu.ucam.actions.ActionUpdate;
import edu.ucam.beans.Alimento;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Hashtable<String, Alimento> alimentos;
	Hashtable<String, Action> actions;
	
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
		
		if (alimentos == null) {
			
		alimentos = new Hashtable<>();
		alimentos.put("Fideo", new Alimento("Fideo", 5));
		alimentos.put("Atun", new Alimento("Atun", 2));
		
		}
		this.getServletContext().setAttribute("ALIMENTOS", alimentos);
		
		
		if (actions == null) {
			actions = new Hashtable<>();
			actions.put("ADD", new ActionAdd());
			actions.put("UPDATE", new ActionUpdate());
			actions.put("DELETE", new ActionDelete());
			actions.put("LISTAR", new ActionListar());
			actions.put("LOGOUT", new ActionLogout());
		}
		
		
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/index.jsp";
		String actionID = request.getParameter("ACTION");
		
		
		if (actionID == null) {
			System.out.println("Acción no definida");
		}else {
			Action action = this.actions.get(actionID);
			
			if (action == null) {
				System.out.println("Acción no encontrada");
			} else {
				jsp = action.execute(request, response);
			}
		}
		
		request.getRequestDispatcher(jsp).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
