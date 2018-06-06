<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scriptlets</title>
</head>
<body>

<h2>JSP con Scriptlets</h2>
<h2><%= "Saludos desde Scriptlets" %></h2>
<br>

<%
	String nombreApp = request.getContextPath();
	out.println(nombreApp);
%>
<br>

<%
	if(session != null && session.isNew()){
%>	
	<h4>La sesión es nueva</h4>
<%	
	}else if(session != null){
%>
	<h4>La sesión NO es nueva</h4>
<%		
	}
%>


</body>
</html>