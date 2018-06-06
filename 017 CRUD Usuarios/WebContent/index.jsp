<%@page import="edu.ucam.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios</title>
</head>
<body>

	

<%
	User user = (User) request.getSession().getAttribute("LOGGED");
	if(user == null){
%>
	${ MSG }
	<br><br>
	<form action="Control?ACTION=LOGIN" method="post">
	User: <input type="text" name="USER" value="admin"><br>
	Pass: <input type="password" name="PASS" value="1234"><br>
	<input type="submit">
	</form>
<%
	}else{
%>
	
	${ MSG }
	<h3>Insertar nuevo Usuario</h3>
	<form action="Control?ACTION=ADD" method="post">
	User: <input type="text" name="USER" value="admin"><br>
	Pass: <input type="password" name="PASS" value="1234"><br>
	<input type="submit">
	</form>
	<br><br>
	<a href="Control?ACTION=LIST">Listar Usuarios</a><br>
	<a href="Control?ACTION=LOGOUT">Salir</a>
<%	
	}
%>

${ MSGOUT }

	


	

</body>
</html>