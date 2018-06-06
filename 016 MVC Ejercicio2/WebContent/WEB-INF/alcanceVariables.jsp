<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alcance Variables</title>
</head>
<body>

<h1>Alcance Variables</h1>

<br>
Variable Request:
Base: ${rectanguloR.base}
Altura: ${rectanguloR.altura}
Area: ${rectanguloR.area }
<br><br>
Variable Session:
Base: ${rectanguloS.base }

<br><br>
Variable Context:
Base: ${rectanguloC.base }


<a href="index.jsp">Regresar</a>
</body>
</html>