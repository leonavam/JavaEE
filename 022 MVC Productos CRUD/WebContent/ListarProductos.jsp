<%@page import="edu.home.beans.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListaProductos</title>

<style type="text/css">

	table{
		float: left;
	}
	
	#insertarRegistro{
		margin-left: 500px
	}

</style>
</head>
<body>


<table border="1">
	<tr>
		<th>Código</th>
		<th>Sección</th>
		<th>Nombre Artículo</th>
		<th>Precio</th>
		<th>Fecha</th>
		<th>Importado</th>
		<th>País Origen</th>
	</tr>
	
	<c:forEach var="prod" items="${PRODUCTOS }">
		<tr>
			<td><c:out value="${prod.idArt }"/></td>
			<td><c:out value="${prod.seccion }"/> </td>
			<td><c:out value="${prod.nombreArt }"/> </td>
			<td><c:out value="${prod.precio }"/> </td>
			<td><c:out value="${prod.fecha }"/> </td>
			<td><c:out value="${prod.importado }"/> </td>
			<td><c:out value="${prod.paisOrigen }"/> </td>
		</tr>
	</c:forEach>
</table>

<div id="insertarRegistro">

	<input type="submit" value="Insertar Registro" onclick="window.location.href='insert.jsp'"/>
	
</div>






</body>
</html>