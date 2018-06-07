<%@page import="edu.ucam.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RepasoExamen</title>
</head>
<body>

	<br>
	<form action="Control?ACTION_ID=LOGIN" method="post">
	Nombre: <input type="text" value="admin" name="NAME"><br>
	Clave: <input type="text" value="1234" name="PASS"><br><br>
	<input type="submit">
	</form>

<%
	User user = (User) session.getAttribute("LOGGED");
	if (user != null){
%>
	Welcome, <%= user.getName() %>
	<br>
<%
	}else{
%> Usuario no encontrado
<%
	}
%>
</body>
</html>