<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar Cursos</title>
</head>
<body>
	
	<br>
		<fieldset>
		<legend> Actualizar Curso:</legend>
		<form action="Control?ACTION_ID=UPDATECURSO" method="post">
			<input type="hidden" name="UPDATEOK" value="ok">
			Nombre Curso:<input type="text" name="NAMECURSO" value="${ UPNAME }" readonly="readonly"><br>
			Creditos:<input type="number" name="CREDITOS" required min="3" max="6" step="0.5"><br>
			Profesor:<input type="text" name="PROFESOR" required><br>
			<input type="submit">
		</form>		
	
	
</body>
</html>