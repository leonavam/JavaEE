<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo Manejo JSPS </title>
</head>
<body>

	<h2>Ejemplo de Expresiones</h2>
	<a href="expresiones.jsp">Expresiones JSP</a>
	
	<form action="procesaFormulario.jsp">
		User: <input type="text" name="USER" value="admin"><br>
		Pass: <input type="password" name="PASS" value="1234"><br>
		<input type="submit">
	</form>
	
	<hr>
	
	
	<a href="scriptlets.jsp">Scriptlets</a><br>
	<br>
	<form action="fondoColor.jsp">
		Proporciona el color de fondo(red, blue, ...): <input type="text" name="COLOR_FONDO"><br>
		<input type="submit">
	</form>
	
	<br>
	<hr>
	
	
</body>
</html>