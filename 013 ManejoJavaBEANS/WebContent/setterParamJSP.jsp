<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP modifica JavaBean por parámetro</title>
</head>
<body>
<h2>JSP modifica JavaBean por parámetro</h2>

<jsp:useBean id="rectangulo" class="edu.home.beans.Rectangulo" scope="session" />
<br>

Modificación en los atributos:
<br>

<jsp:setProperty property="base" name="rectangulo" param="BASE"/>
<br>
<jsp:setProperty property="altura" name="rectangulo" param="ALTURA"/>
<br>

<a href="index.jsp">Regresar</a>


</body>
</html>