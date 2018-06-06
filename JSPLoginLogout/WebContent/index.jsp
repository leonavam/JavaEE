<%@page import="edu.ucam.beans.User"%>
<%@ page errorPage="error.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<%

	User user = (User) session.getAttribute("USER_LOGGED");

	if (user == null){
		if (request.getAttribute("MSG")!=null){
			out.println(request.getAttribute("MSG")+"<br>");
		}
%>
<h2>Iniciar Sesión</h2><br>
<form action="ServletLogin" method="post">
Nombre:<input type="text" value="admin" name="NAME"><br>
	Clave:<input type="text" value="1234" name="PASS"><br>
		<input type="submit">
	</form>

<%
		
	}else{

		%>

		<h3>Welcome, <%= user.getName() %> </h3><br>
		<%
			if(request.getAttribute("MSG") != null){
				out.println(request.getAttribute("MSG") + "<br>");
			}
		%>
		<form action="AddUser" method="post">
			<h2>Inserta Nuevo Usuario</h2><br>
			Nombre: <input type="text" name="NewNAME"><br>
			Clave: <input type="text" name="NewPASS"><br>
			<input type="submit"><br>
		</form>
		<br><a href="ServletBorrar">Listar</a>
		<br><a href="ServletLogout">Salir</a>

		<%
		
		
	}


%>
</body>
</html>