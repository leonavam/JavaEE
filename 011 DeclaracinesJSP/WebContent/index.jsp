<%-- Esto es un comentario --%>
<%!
	private String user = "Erik";
	public String getUser(){
		return this.user;
	}
	
	//Contador
	private int Visitas = 1;

%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uso declaraciones</title>
</head>
<body>

<h2>Usuario por medio del atributo: <%= this.user %></h2>
<br>
<h3>Usuario por método get: <%= this.getUser() %></h3>
<br>
<h4>Contador Visitas desde el Inicio del servidor: <%= this.Visitas++ %></h4>
</body>
</html>