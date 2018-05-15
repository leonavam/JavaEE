<%@page import="edu.ucam.beans.User"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<body>
<%
	//Intentamos recuperar el usuario que ha iniciado sesión.
	User user = (User) session.getAttribute("USER_LOGGED");
	//Si no existe usuario mostramos por pantalla el formulario de login.
	if (user == null){
		//Si el servlet nos envió un mensaje lo ponemos encima del formulario.
		if (request.getAttribute("MSG")!=null){
			out.println(request.getAttribute("MSG")+"<br>");
		}
%>

<form action="Control?ACTION_ID=LOGIN" method="post">
Nombre:<input type="text" value="admin" name="NAME"><br>
	Clave:<input type="text" value="1234" name="PASS"><br>
		<input type="submit">
	</form>

<%		
	}else{
		//Si el usuario existe le damos la bienvenida y mostramos el formulario de alta de usuarios.	
%>

		Welcome, <%= user.getName() %>
		<br>
		<br>
<%
		//Si el servlet de alta nos envía un mensaje lo mostramos.
		if (request.getAttribute("MSG")!=null){
			out.println(request.getAttribute("MSG")+"<br>");
		}

		//Mostramos el formulario de alta de usuario.		
%>
		<br>
		<h3>Insertar Nuevo Usuario</h3>
		<form action="Control?ACTION_ID=ADDUSER" method="post">
			Nombre:<input type="text" name="NAME"><br>
			Clave:<input type="text" name="PASS"><br>
			<input type="submit">
		</form>		
		
		<br><br>
		<a href="Control?ACTION_ID=LISTAR">Listar con Action</a>
		<br>
		<a href="Control?ACTION_ID=LOGOUT">Salir</a>

<%	
	}
%>
</body>
</html>