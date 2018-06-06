<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Variables</title>
</head>
<body>
<h3>Alcance Request</h3>
${ msj }

<br><hr>
<h3>Alcance Session</h3>
<h4>Con EL</h4>
Base: ${ rectangulo.base } <br>
Altura: ${ rectangulo.altura } <br>
Area: ${ rectangulo.area} <br>
<h4>Con request</h4>

base: <%= request.getSession().getAttribute("rectangulo") %>



<br>
<a href="index.jsp"> Regresar </a>
</body>
</html>