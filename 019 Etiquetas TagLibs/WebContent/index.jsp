<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
    <%
    	ArrayList<String> alumnos = new ArrayList<String>();
    	alumnos.add("Antonio");
    	alumnos.add("Leo");
    	alumnos.add("Erik");
    	alumnos.add("Paco");
    
    	String personas[] = {"leo","erik","carlos","juan"};
    	pageContext.setAttribute("PERSON", personas);
    	
    	pageContext.setAttribute("ALUMNOS", alumnos);
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TagLib Core</title>
</head>
<body>

	<br><br>
	<h3>Con etiqueta forEach</h3>
	
<c:forEach var="alum" items="${PERSON}">
	${alum}
	<br>
</c:forEach>
<br>
<c:forEach var="alum" items="${ALUMNOS }">

	<c:out value="${alum }"/> 
	<br>

</c:forEach>


</body>
</html>