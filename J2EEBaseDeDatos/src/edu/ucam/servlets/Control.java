package edu.ucam.servlets;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import edu.ucam.acciones.Accion;
import edu.ucam.dao.Factory;
import edu.ucam.dao.factories.FileFactory;
import edu.ucam.dao.factories.MySQLFactory;

public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PRM_ACCION = "PRM_ACCION_CONTROL"; 
	
	private Hashtable<String, Accion> hashAcciones = null;
	
	private static Factory factory = null;
	
	@Resource(name="jdbc/dad2")
	private static DataSource ds;
	
	
	public void init() throws ServletException {
		System.out.print("Inicializando...");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			/*
			 * Listar atributos de la clase actual
			Field[] campos = this.getClass().getDeclaredFields();			
			for(int i=0;i<campos.length;i++)
				System.out.println(campos[i].getName());
				*/
			
			Connection con = Control.ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM ACTIONS");
			rs = ps.executeQuery();		
			
			Accion accion = null;
			this.hashAcciones = new Hashtable<String, Accion>();
			while(rs.next()){				
				accion = (Accion)Class.forName(rs.getString("class")).newInstance();				
				String id = rs.getString("id");
				System.out.println(id + " "+ accion);
				this.hashAcciones.put(id, accion);			
			}
			
		} catch (SQLException e) {
			System.out.println("Error: "+ e.toString());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				if (rs != null)	rs.close();
				if (ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("[ok]");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Accion accion = null;
		try{
			accion = this.hashAcciones.get(request.getParameter(Control.PRM_ACCION));
			accion.ejecutar(request, response);
		}catch(NullPointerException npe){
			accion = hashAcciones.get("NOACCION");
			accion.ejecutar(request, response);
		}
	}
	
	public static DataSource getDataSource(){
		return Control.ds;
	}
	
	public static Factory getFactory(){
		if (Control.factory == null){
			Control.factory = new MySQLFactory();
		}
		return Control.factory;
	}

}
