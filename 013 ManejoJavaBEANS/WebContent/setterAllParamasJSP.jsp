<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP que modifica un JavaBEAN por parámetros</title>
</head>
<body>
<h2>JSP que modifica un JavaBEAN por parámetros</h2>

<jsp:useBean id="rectangulo" class="edu.home.beans.Rectangulo" scope="session" /><br>

<jsp:setProperty property="*" name="rectangulo"/>

Se modificaron los atributos: <br>
Base: <jsp:getProperty property="base" name="rectangulo"/><br>
Altura: <%= request.getParameter("altura") %><br>

<hr>
<h3>Ahora con EL (Expression Language)</h3>
Valor base: ${rectangulo.base} <br>
Valor altura: ${rectangulo.altura} <br>
Valor area: ${rectangulo.area} <br>

Cálculo del área: ${ rectangulo.base * rectangulo.altura }<br>

<a href="index.jsp">Regresar</a>


</body>
</html>