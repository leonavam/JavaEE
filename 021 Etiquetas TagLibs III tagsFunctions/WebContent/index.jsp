<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tags Functions</title>
</head>
<body>

	<c:set var="datos" value="Ana, López, Directora, 25000"/>
	
	<c:set var="datosArray" value= "${fn:split(datos, \",\")}"/>	
	
	
	<input type="text" value="${datosArray[0]}"><br>
	<input type="text" value="${datosArray[1]}"><br>
	<input type="text" value="${datosArray[2]}"><br>
	<input type="text" value="${datosArray[3]}">

	

</body>
</html>