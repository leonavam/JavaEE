<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jsp Lector</title>
</head>
<body>
<h1>Jsp lector de valores JavaBEAN</h1>

<jsp:useBean id="rectangulo" class="edu.home.beans.Rectangulo" scope="session" />

<br>
Valor base: <jsp:getProperty property="base" name="rectangulo"/><br>
Valor altura: <jsp:getProperty property="altura" name="rectangulo"/><br>
Valor area: <jsp:getProperty property="area" name="rectangulo"/>

<br><br>
<a href="index.jsp">Regresar</a>

</body>
</html>