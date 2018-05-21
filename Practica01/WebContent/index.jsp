<%@page import="edu.ucam.beans.User"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión Academia</title>
</head>
<body>

<body>

<%
	//Intentamos recuperar el usuario que ha iniciado sesión.
	User user = (User) session.getAttribute("USER_LOGGED");
	String rol = (String) session.getAttribute("ROL");
	//Si no existe usuario mostramos por pantalla el formulario de login.
	if (user == null){
%>
	${MSG}
	
	<form action="Control?ACTION_ID=LOGIN" method="post">
		Nombre:<input type="text" value="admin" name="NAME" required><br>
		Clave:<input type="text" value="admin" name="PASS" required><br>
		<input type="submit">
	</form>

<%		
	}else if(user != null && !("Gestor".equals(rol))){
		//Si el usuario existe le damos la bienvenida y mostramos el formulario de alta de usuarios.	
%>

		Bienvenido, <%= user.getName() %> usted es <%= user.getRol() %>
		<br>
		<br>

		${MSG}
		
		<br>
		<fieldset>
		<legend> CRUD Usuarios:</legend>
		<h3>Insertar Nuevo Usuario</h3>
		<form action="Control?ACTION_ID=ADDUSER" method="post">
			Nombre:<input type="text" name="NAME" required><br>
			Clave:<input type="text" name="PASS" required><br>
			Rol:<input type="text" name="ROL" required><br>
			<input type="submit">
		</form>		
		
		<br><br>
		<a href="Control?ACTION_ID=LISTAR">Listar Usuarios</a>
		<br>
		</fieldset>

		<br>
		<fieldset>
		<legend> CRUD Cursos:</legend>
		<h3>Insertar Nuevo Curso</h3>
		<form action="Control?ACTION_ID=ADDCURSO" method="post">
			Nombre Curso:<input type="text" name="NAMECURSO" value="curso01" required><br>
			Creditos:<input type="number" name="CREDITOS" value="4" required min="3" max="6" step="0.5"><br>
			Profesor:<input type="text" name="PROFESOR" value="profesor1" required><br>
			<input type="submit">
		</form>		
		
		<br><br>
		<a href="Control?ACTION_ID=LISTARCURSO">Listar Usuarios</a>
		<br>
		</fieldset>
		<br>
		<a href="Control?ACTION_ID=LOGOUT">Terminar Sesión</a>
		
<%	
	}else{
%>
	Bienvenido, <%= user.getName() %> usted es <%= user.getRol() %>
		<br>
		<br>
		
		<fieldset>
		<legend> CRUD Cursos:</legend>
		<h3>Insertar Nuevo Curso</h3>
		<form action="Control?ACTION_ID=ADDCURSO" method="post">
			Nombre Curso:<input type="text" name="NAMECURSO" value="curso01" required><br>
			Creditos:<input type="number" name="CREDITOS" value="4" required min="3" max="6" step="0.5"><br>
			Profesor:<input type="text" name="PROFESOR" value="profesor1" required><br>
			<input type="submit">
		</form>		
		
		<br><br>
		<a href="Control?ACTION_ID=LISTARCURSO">Listar Usuarios</a>
		<br>
		</fieldset>
		
		
	<a href="Control?ACTION_ID=LOGOUT">Salir</a>
<% 
	} 
%>


</body>
</html>