<%@page import="java.util.Enumeration"%>
<%@page import="edu.ucam.beans.User"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="ccs/stylesListar.css">
<title>Lista usuarios</title>
</head>
<body>
<div class="w3-container w3-center w3-animate-opacity">
<h3>Listado usarios</h3><br>

<%

Hashtable<String, User> users = ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS"));

%>	

	<table class="w3-table-all">
		<tr class="w3-teal">
			<th>Usuario</th>
			<th>Contraseña</th>
			<th>Rol</th>
			<th></th>
			<th></th>
		</tr>

		<% 
for(Enumeration enumeration = users.elements(); enumeration.hasMoreElements();){
	User user = (User) enumeration.nextElement();
%>
	<tr>
		<td><%= user.getName() %></td>
		<td><%= user.getPass() %></td>
		<td><%= user.getRol() %></td>
		<td><a id="update" href="Control?ACTION_ID=UPDATEUSER&NAME=<%=user.getName() %>">Actualizar </a></td>
		<td><a href="Control?ACTION_ID=DELETEUSER&NAME=<%=user.getName() %>">Borrar </a></td>
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