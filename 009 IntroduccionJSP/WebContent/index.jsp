<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hola mundo con varias tecnologías</h2>
	<ul>
		<li>Hola Mundo HTML
		<li><% out.println("Hola mundo con Scriplets"); %>
		<li>${"Hola Mundo con Expression Languaje (EL)" }
	</ul>
	
	<ul>
		<li>Hola <%= new Date() %>
		<li>Nombre contexto: <%= request.getContextPath() %>
		<li>Valor parámetro: <%= request.getParameter("X") %>
	</ul>
	
</body>
</html>