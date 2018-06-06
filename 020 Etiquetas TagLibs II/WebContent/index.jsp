<%@page import="edu.home.beans.Empleado"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <%
    
    	ArrayList<Empleado> empleados = new ArrayList<>();
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    try{
    	
    	Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectpJSP?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "");
    	Statement statement = myConnection.createStatement();
    	String sql = "SELECT * FROM empleados";
    	ResultSet rs = statement.executeQuery(sql);
    	
    	while(rs.next()){
    		empleados.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
    	}
    	
    	rs.close();
    	statement.close();
    	myConnection.close();
    	
    	pageContext.setAttribute("EMPLEADOS", empleados);
    	
    }catch(Exception e){
    	out.println("Error de conexion");
    	e.printStackTrace();
    }
    
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recorre empleados</title>

<style type="text/css">
	
	.cabecera{
		font-weight: bold;
	}

</style>
</head>
<body>

<table border="1">
<tr class="cabecera">
	<td>Nombre</td><td>Apellido</td><td>Puesto</td><td>Salario</td><td>Bonus</td><td>DirectoSalario</td>
</tr>
	<c:forEach var="emp" items="${EMPLEADOS }">
	<tr>
		<td><c:out value="${emp.nombre }"/></td>
		<td><c:out value="${emp.apellido }"/> </td>
		<td><c:out value="${emp.puesto }"/> </td>
		<td><c:out value="${emp.salario }"/> </td>
		<td>
		<c:if test="${emp.salario < 2000}">5000</c:if>
		<c:if test="${emp.salario > 2000}">----</c:if>
		</td>
		<td>
			<!-- choose inicia el SWITCH, when cada CASE y otherwise = DEFAULT-->
			<c:choose>
				<c:when test="${emp.salario < 2000 }"> 
					${emp.salario + 1000}
				</c:when>
				
				<c:when test="${emp.salario > 2000 && emp.salario <3000}">
					${emp.salario + 2000}
				</c:when>
				
				<c:otherwise>${emp.salario }</c:otherwise> 
		
			</c:choose>
			
		</td>
		
	</tr>
		
	</c:forEach>
	
</table>

</body>
</html>