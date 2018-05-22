package edu.ucam.beans;

public class User {
	private String name;
	private String pass;
	private String rol;
	
	public User(String name, String pass, String rol) {
		super();
		this.name = name;
		this.pass = pass;
		this.rol = rol;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
	
}
