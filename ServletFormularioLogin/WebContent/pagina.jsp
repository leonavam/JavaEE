<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
El resultado de 5 * 6 es:<h1><%=5*6%></h1>

<% 

	out.println(session.getAttribute("USER")+ "<br>");
	out.println(request.getParameter("PARAM1")+ "<br>");


for (int i=0;i<=4;i++) { 

	out.println(i + " * 10 = " + (i*10) + "<br>");


}%>

</body>

</html>