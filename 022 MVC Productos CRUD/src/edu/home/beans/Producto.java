package edu.home.beans;

public class Producto {
	
	private String idArt;
	private String seccion;
	private String nombreArt;
	private double precio;
	private String fecha;
	private boolean importado;
	private String paisOrigen;
	
	
	public Producto(String idArt, String seccion, String nombreArt, double precio, String fecha, boolean importado,
			String paisOrigen) {
		this.idArt = idArt;
		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}

	public Producto(String seccion, String nombreArt, double precio, String fecha, boolean importado,
			String paisOrigen) {
		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}

	public String getIdArt() {
		return idArt;
	}

	public void setIdArt(String idArt) {
		this.idArt = idArt;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombreArt() {
		return nombreArt;
	}

	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	

}
