<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo Java Beans</title>
</head>
<body>

<h2>Ejemplo Java Beans</h2>
<a href="setter.jsp">Modificar valores del JavaBEAN</a><br>
<a href="getter.jsp">Leer valores del JavaBEAN</a><br>
<h3>Formulario 1</h3>
<form action="setterParamJSP.jsp" method="get">

	Base: <input type="text" name="BASE"><br>
	Altura: <input type="text" name="ALTURA"><br>
	<input type="submit">

</form>
<br>
<h3>Formulario 2</h3>
<form action="setterAllParamasJSP.jsp" method="get">

	Base: <input type="text" name="base"><br>
	Altura: <input type="text" name="altura"><br>
	<input type="submit">

</form>


</body>
</html>