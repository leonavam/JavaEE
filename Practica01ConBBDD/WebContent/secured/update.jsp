<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="dad2" uri="mistags"%>
<!DOCTYPE html">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link rel="stylesheet" href="ccs/styleUpdate.css">
<title>Actualizar Usuarios</title>
</head>
<body>
	<dad2:control>
		<header>
			<div class="container">
				<h1>Actualiza Usuarios</h1>
			</div>
		</header>
		<br>

		<form action="Control?ACTION_ID=UPDATEUSER" method="post"
			class="container">
			<input type="hidden" name="UPDATEOK" value="ok"> Id: <input
				type="text" name="ID" value="${ ID }" readonly="readonly"
				class="form-control"><br> Nombre:<input type="text"
				name="NAME" value="${ UPNAME }" class="form-control"><br>
			Clave:<input type="text" name="PASS" required class="form-control"><br>
			Rol:<select name="ROL" class="form-control">
				<option value="Administrador">Administrador</option>
				<option value="Gestor">Gestor</option>
			</select> <br>
			<button class="btn btn-success">Actualizar</button>
		</form>

		<footer>
			<div class="container text-right">
				<p>
					DAD 2 Gestión Academia <br> Erik Navarrete
				</p>

			</div>
		</footer>
	</dad2:control>
</body>
</html>