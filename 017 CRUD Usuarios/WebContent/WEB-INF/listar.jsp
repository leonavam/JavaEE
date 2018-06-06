<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@page import="edu.ucam.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar</title>
</head>
<body>

<h1>Hello</h1>

<%

	Hashtable<String, User> users= ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS"));

	for(Enumeration enumeration = users.elements(); enumeration.hasMoreElements();){
		User user = (User)enumeration.nextElement();
		out.println(user.getUser() + " " + user.getPass() + " <a href=\"Control?ACTION=DEL&NAME="+user.getUser()+"\"> Borrar</a></br>");
	}
%>

<br><br>
<a href="index.jsp">Regresar</a>



</body>
</html>