package edu.ucam.beans;

public class Alimento {

	private String alimento;
	private int cantidad;
	
	public Alimento(String alimento, int cantidad) {
		super();
		this.alimento = alimento;
		this.cantidad = cantidad;
	}
	
	public String getAlimento() {
		return alimento;
	}
	
	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
