<%@page import="edu.ucam.beans.User"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="ccs/styles.css">

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
	<center>

		<div class="login">
			<div class="w3-container w3-center w3-animate-opacity">
				<form action="Control?ACTION_ID=LOGIN" method="post">
					<input class="login-input" type="text" name="NAME" required
						placeholder="Usuario" autofocus><br> <input
						class="login-input" type="text" name="PASS" required
						placeholder="Contraseña"><br> <input type="submit"
						value="Login">
				</form>
				<div class="w3-container w3-red">${MSG}</div>
			</div>
		</div>
	</center>
	<%		
	}else if(user != null && !("Gestor".equals(rol))){
		//Si el usuario es Administrador podrá ver los cruds correspondientes	
%>

	<div class="w3-container w3-teal">
		<h1>GESTION DE ACADEMIA</h1>
		<p class="hello">
			Bienvenido,
			<%=user.getName()%></p>
			<div class="closeSes">
		<p class="logout">
			<a class="dejar" href="Control?ACTION_ID=LOGOUT">Salir</a>
		</p></div>
	</div>

	<center>
		<div class="caja">
			<div class="w3-container w3-center w3-animate-opacity">

				<br>
				<fieldset>
					<legend> CRUD Usuarios:</legend>
					<h3>Insertar Nuevo Usuario</h3>
					<form action="Control?ACTION_ID=ADDUSER" method="post">

						<table style="margin: 0 auto;">

							<tr>
								<td><b>Nombre:</b></td>
								<td><input type="text" name="NAME" required></td>
							</tr>
							<tr>
								<td><b>Clave:</b></td>
								<td><input type="text" name="PASS" required></td>
							</tr>
							<tr>
								<td><b>Rol:</b></td>
								<td>
								
								<select name="ROL">
								  <option value="Administrador">Administrador</option>
								  <option value="Gestor">Gestor</option>
								</select>
								
								
								</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit"></td>
							</tr>
						</table>


					</form>
					${MSG}
					<br> <br> <a href="Control?ACTION_ID=LISTAR">Listar
						Usuarios</a> <br>
				</fieldset>
			</div>
		</div>
		<div class="caja">
			<div class="w3-container w3-center w3-animate-opacity">

				<br>
				<fieldset>
					<legend> CRUD Cursos:</legend>
					<h3>Insertar Nuevo Curso</h3>
					<form action="Control?ACTION_ID=ADDCURSO" method="post">
						<table style="margin: 0 auto;">

							<tr>
								<td><b>Nombre Curso:</b></td>
								<td><input type="text" name="NAMECURSO" value="curso01"
									required></td>
							</tr>
							<tr>
								<td><b>Creditos:</b></td>
								<td><input type="number" name="CREDITOS" value="4" required
									min="3" max="18" step="0.5"></td>
							</tr>
							<tr>
								<td><b>Profesor:</b></td>
								<td><input type="text" name="PROFESOR" value="profesor1"
									required></td>
							<tr>
								<td></td>
								<td><input type="submit"></td>
							</tr>
						</table>
					</form>
					${MSGc}
					<br> <br> <a href="Control?ACTION_ID=LISTARCURSO">Listar
						Cursos</a> <br>
				</fieldset>
			</div>
		</div>
	</center>

	<%
		} else {
	%>

	<div class="w3-container w3-teal">
		<h1>GESTION DE ACADEMIA</h1>
		<p class="hello">
			Bienvenido,
			<%=user.getName()%></p>
		<div class="closeSes">
		<p class="logout">
			<a class="dejar" href="Control?ACTION_ID=LOGOUT">Salir</a>
		</p></div>
	</div>
	<br>
	<br>
	<div class="w3-container w3-center w3-animate-opacity">
		<fieldset>
			<legend> CRUD Cursos:</legend>
			<h3>Insertar Nuevo Curso</h3>
			<form action="Control?ACTION_ID=ADDCURSO" method="post">

				<table style="margin: 0 auto;" >

					<tr>
						<td><b>Nombre Curso:</b></td>
						<td><input type="text" name="NAMECURSO" value="curso01"
							required></td>
					</tr>
					<tr>
						<td><b>Creditos:</b></td>
						<td><input type="number" name="CREDITOS" value="4" required
							min="3" max="6" step="0.5"></td>
					</tr>
					<tr>
						<td><b>Profesor:</b></td>
						<td><input type="text" name="PROFESOR" value="profesor1"
							required></td> 
					<tr><td></td><td><input type="submit"></td></tr>
				</table>
				
			</form>
			<div class="w3-container w3-red">${MSGc}</div>
			<br>
			<br> <a href="Control?ACTION_ID=LISTARCURSO">Listar Cursos</a>
			<br>
		</fieldset>
	</div>
	<% 
	} 
%>

	<div id="pie">
		<div class="w3-container w3-teal">
			<p class="izq">
				DAD 2 Gestión Academia<br> Erik Navarrete
			</p>
		</div>
	</div>

</body>
</html>