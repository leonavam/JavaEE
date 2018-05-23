<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="ServletPrueba">Mostrar Datos</a><br><br>


<%
	ArrayList<String> arts = (ArrayList<String>)request.getSession().getAttribute("ARTICULOS");	

	if(arts == null){
		for(String name : arts){
			out.println(name + "<br>");
		}
	}

%>
<hr>

<a href="Productos">Aplicación Real CRUD</a>

<h1>Hello desde Github</h1>
<h2>Hello desde ACER</h2>

</body>
</html>