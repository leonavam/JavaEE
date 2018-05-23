<%@page import="edu.ucam.beans.Curso"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="ccs/stylesListar.css">
<title>Lista Cursos</title>
</head>
<body>
<div class="w3-container w3-center w3-animate-opacity">
<h3>Listado de Cursos</h3><br>

<%

Hashtable<String, Curso> cursos = ((Hashtable<String, Curso>)request.getServletContext().getAttribute("CURSOS"));

%>	

<table class="w3-table-all">
	<tr class="w3-teal">
		<th>Nombre</th>
		<th>Créditos</th>
		<th>Profesor</th>
		<th></th>
		<th></th>
	</tr>

	<% 


for(Enumeration enumeration = cursos.elements(); enumeration.hasMoreElements();){
	Curso curso = (Curso) enumeration.nextElement();
	%>
	<tr>
		<td><%= curso.getNombreCurso() %></td>
		<td><%= curso.getCreditos() %></td>
		<td><%= curso.getProfesor() %></td>
		<td><a id="update" href="Control?ACTION_ID=UPDATECURSO&NAMECURSO=<%=curso.getNombreCurso() %>">Actualizar </a></td>
		<td><a href="Control?ACTION_ID=DELCURSO&NAME=<%=curso.getNombreCurso() %>">Borrar </a></td>
	</tr>
	
<%
}
%> 
	</table>

<br><br>
<form action="index.jsp" method="post">
<button class="w3-button w3-green" type="submit">Volver</button>
</form>
</div>
</body>
</html>