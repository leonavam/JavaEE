<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modificar valores a JavaBEAN</title>
</head>
<body>

<h1>Modificar valores a JavaBEAN</h1>

<jsp:useBean id="rectangulo" class="edu.home.beans.Rectangulo" scope="session" />
<br>
	<%
		int base = 5;
		int altura = 10;	
	%>

<jsp:setProperty property="base" name="rectangulo" value="<%= base %>"/><br>
<jsp:setProperty property="altura" name="rectangulo" value="<%= altura %>"/><br>

<br><br>
<a href="index.jsp">Regresar</a>


</body>
</html>