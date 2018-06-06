<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parámetros de Aplicación</title>
</head>
<body>

	El servlet de origen se ha iniciado els <%=
		((GregorianCalendar)getServletContext().getAttribute("HORA_INICIO")).getTime()
	%>
	

</body>
</html>