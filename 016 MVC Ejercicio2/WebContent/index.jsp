<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo MVC 2</title>
</head>
<body>
<h1>Ejemplo MVC</h1>

<div style="color: aqua">${ msj }</div>
<br>
<a href="ServletControlador">ServletControlador</a>
<br>
<a href="ServletControlador?ACCION=agregaVariables">AgregarVariables</a>
<br>
<a href="ServletControlador?ACCION=listarVariables">ListarVariables</a>
<br>
</body>
</html>