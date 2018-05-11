package edu.home.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.home.beans.Producto;

public class ModeloProductos {
	
	private DataSource datos;

	public ModeloProductos(DataSource datos) {
		this.datos = datos;
	}
	
	public ArrayList<Producto> getProductos() throws Exception{
		
		ArrayList<Producto> productos = new ArrayList<>();
		
		Connection myConnection = datos.getConnection();	//Conexion creada
		String sql = "SELECT * FROM PRODUCTOS"; //Preparamos el sql
		Statement st = myConnection.createStatement();		
		ResultSet rs = st.executeQuery(sql);
		
		
		while(rs.next()) {
			productos.add(new Producto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), 
					rs.getString(5), rs.getBoolean(6), rs.getString(7)));
		}
		
		return productos;
	}
	
	

}
