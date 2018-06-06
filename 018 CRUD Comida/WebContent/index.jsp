<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Control?ACTION=ADD" method="post">
	<input type="hidden" name="INICIO">
	Inserta alimento: <input type="text" name="ALIMENTO">
	Cantidad: <input type="text" name= "CANT"><br>
	<input type="submit">
</form>

<hr>
<h3>Actualizar alimentos</h3>
<br>
<form action="Control?ACTION=UPDATE" method="post">
	<input type="hidden" name="INICIO">
	Inserta alimento: <input type="text" name="ALIMENTO">
	Cantidad: <input type="text" name= "CANT"><br>
	<input type="submit">
</form>
<br><hr>
<a href="Control?ACTION=LISTAR">Listar</a><br>


</body>
</html>