<%@page import="edu.ucam.beans.Curso"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Cursos</title>
</head>
<body>
<h3>Listado de Cursos</h3><br>

<%

Hashtable<String, Curso> cursos = ((Hashtable<String, Curso>)request.getServletContext().getAttribute("CURSOS"));


for(Enumeration enumeration = cursos.elements(); enumeration.hasMoreElements();){
	Curso curso = (Curso) enumeration.nextElement();
	
	out.println(curso.getNombreCurso() + " " + curso.getCreditos()+ " " + curso.getProfesor() 
	+ " <a href=\"Control?ACTION_ID=UPDATECURSO&NAMECURSO="+curso.getNombreCurso()+"\">Actualizar</a> "
	+ " <a href=\"Control?ACTION_ID=DELCURSO&NAME="+curso.getNombreCurso()+"\">Borrar</a><br>");
}


%>

<a href="index.jsp">Volver</a>
</body>
</html>