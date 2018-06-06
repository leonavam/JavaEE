<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>JSP de expresiones</h1>
	
	Concatenación: <%= "Saludos " + "JSP" %><br>
	Op Matemática: <%= 2*3/2 %><br>
	
	Session id: <%= session.getId() %><br>
	
	<a href="index.jsp">Regresa a Index</a>


</body>
</html>