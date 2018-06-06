<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tipos Navegadores</title>
</head>
<body>

	<h1>Ejemplo Navegadores</h1>
	<a href="Servlet">Tipo de Navegador</a>
	<br><br>
	
	<h1>Titulo <%= request.getAttribute("Titulo") %></h1>
	
	<%
		out.println(request.getAttribute("Titulo") + "<br>");
		out.println(request.getAttribute("Msj")+ "<br>");
	%>
	
</body>
</html>