<%@ page isErrorPage="true" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manejo Errores</title>
<script type="text/javascript" src="<%= request.getContextPath()%>/recursos/funciones.js"></script>
</head>
<body>
<h3>Ocurrión un error!</h3>
<%= exception.getMessage() %>


</body>
</html>