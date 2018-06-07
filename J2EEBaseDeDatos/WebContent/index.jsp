<%@page import="edu.ucam.servlets.Control"%>
<html>
<head>
	<title>Prueba BD</title>
</head>
<body>

Hemos llegado


<br/><br/><br/>

<%


out.println("<a href=\"Control?" + Control.PRM_ACCION + "=LISTARUSERS\">Listar usuarios</a>");

%>

</body>

</html>