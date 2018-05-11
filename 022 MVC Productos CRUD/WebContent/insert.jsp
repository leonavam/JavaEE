<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insertar Artículo</title>
</head>
<body>
	
	<h1>Insertar Artículo</h1>

<form action="Productos" method="post">
	<table>
	<tr><td> Id Artículo </td><td> <input type="text" name="idArt"> </td></tr>
	<tr><td> Sección </td><td> <input type="text" name="seccion"> </td></tr>
	<tr><td> Nombre Artículo </td><td> <input type="text" name="nombreArt">  </td></tr>
	<tr><td> Precio </td><td> <input type="text" name="precio">  </td></tr>
	<tr><td> Fecha</td><td> <input type="text" name="fecha">  </td></tr>
	<tr><td> Importado </td><td> <input type="text" name="importado">  </td></tr>
	<tr><td> Pais de origenes </td><td> <input type="text" name="paisOrigen">  </td></tr>
	<tr><td></td><td><input type="submit"></td></tr>
	</table>

</form>
</body>
</html>