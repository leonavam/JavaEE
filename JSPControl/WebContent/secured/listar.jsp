<%@page import="java.util.Enumeration"%>
<%@page import="edu.ucam.beans.User"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Listado usarios</h3><br>

<%

Hashtable<String, User> users = ((Hashtable<String, User>)request.getServletContext().getAttribute("USERS"));


for(Enumeration enumeration = users.elements(); enumeration.hasMoreElements();){
	User user = (User) enumeration.nextElement();
	
	out.println(user.getName() + " " + user.getPass()+ " <a href=\"ServletDeleteUser?NAME="+user.getName()+"&RESET=1\">Borrar</a><br>");
}


%>
</body>
</html>