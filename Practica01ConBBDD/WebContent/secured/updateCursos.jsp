<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link rel="stylesheet" href="ccs/styleUpdate.css">
<title>Actualizar Cursos</title>
</head>
<body>
	
	<header>
		<div class="container">
            <h1>Actualiza Cursos</h1>
        </div>
	</header>	
	<br>

		<form action="Control?ACTION_ID=UPDATECURSO" method="post" class="container">
			<input type="hidden" name="UPDATEOK" value="ok">
			<div class="form-group">
			Id: <input type="text" name="ID" value="${ ID }" readonly="readonly" class="form-control">
			</div>
			<div class="form-group">
			Nombre Curso:<input type="text" name="NAMECURSO" value="${ UPNAME }" readonly="readonly" class="form-control">
			</div>
			<div class="form-group">
			Creditos:<input type="number" name="CREDITOS" required min="3" max="15" step="0.5" class="form-control">
			</div>
			<div class="form-group">
			Profesor:<input type="text" name="PROFESOR" required class="form-control">
			</div>
			 <button class="btn btn-success">Actualizar</button>
		</form>		
	
	<footer>
        <div class="container text-right">
        <p>DAD 2 Gestión Academia <br> Erik Navarrete
        </p>
        </div>
    </footer>
</body>
</html>