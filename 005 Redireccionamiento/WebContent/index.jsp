<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Redireccionamiento</title>
</head>
<body>

<h1>Redireccionamiento</h1>

<a href="Redir">Ejemplo Redireccionamiento</a><br>

<form action="FormularioServlet" method="post">

	User: <input type="text" name="USER" value="admin"><br>
	Pass: <input type="password" name="PASS" value="1234"><br>
	<input type="submit"> 

</form>

<%
	String r = (String)session.getAttribute("LOGGED");
	if(r != null){
		out.println("Ha hecho Login correctamente!<br>");
		out.print("Usuario " + request.getParameter("USER") + " PASS" + request.getParameter("PASS"));
	}
%>

</body>
</html>