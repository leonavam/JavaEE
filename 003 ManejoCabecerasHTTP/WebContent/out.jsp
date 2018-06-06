<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SalidaJSP</title>
</head>
<body>

<h1>hola desde JSP</h1>
<%
	out.println("Método HTTP: " + request.getMethod());
	out.print("<br>");
	out.println("URI solicitado: " +request.getRequestURI() + "<br><br>");
	
	Enumeration enumeration = request.getHeaderNames();
	while(enumeration.hasMoreElements()){
		String nombreCabeceros = (String)enumeration.nextElement();
		out.println("<b>" + nombreCabeceros + ": </b>" + request.getHeader(nombreCabeceros) + "<br><br>");
	}
%>
	

</body>
</html>