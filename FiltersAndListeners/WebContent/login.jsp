<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
Para acceder a esta secci&oacute;n debe ser usuario registrado.<br><br>
Pulse en este 

<%
	out.println("<a href=\"" +  request.getContextPath() + "/ServletLogin\">enlace</a>");
%>

para iniciar sesi&oacute;n
</body>
</html>