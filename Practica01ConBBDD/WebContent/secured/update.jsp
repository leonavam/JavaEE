<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar Usuarios</title>
</head>
<body>
	
	<br>
		<fieldset>
		<legend> Actualizar Usuario:</legend>
		<form action="Control?ACTION_ID=UPDATEUSER" method="post">
			<input type="hidden" name="UPDATEOK" value="ok">
			Nombre:<input type="text" name="NAME" value="${ UPNAME }" readonly="readonly"><br>
			Clave:<input type="text" name="PASS" required><br>
			Rol:<input type="text" name="ROL" required><br>
			<input type="submit">
		</form>		
	
	
</body>
</html>