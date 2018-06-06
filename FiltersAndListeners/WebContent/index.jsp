<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo de filtros</title>
</head>
<body>
En este proyecto se muestran tres ejemplos de implementaci&oacute;n de filtros. Tal vez lo primero de todo es preguntarse, ¿qu&eacute; es un filtro? Es un mecanismo que nos permite filtrar las peticiones que se realizan al servidor.<br/><br/>

<u>¿C&oacute;mo se implementa?</u><br/><br/>
Todo filtro debe de implementar de la interfaz <i>import javax.servlet.Filter</i> y configurarlo mediante:  
<ul>
<li>
<b>Anotaciones</b>. Al igual que en los servlet se puede utilizar la anotación <i>@WebFilter</i> 
</li>
<br>
<li>
<b>web.xml</b>. También se puede configurar el fichero web.xml con las etiquetas <i>filter</i> y <i>filter-mapping</i>. 
<br>
<br>

 &ltfilter&gt<br>
    &ltfilter-name&gtMiFiltro&lt/filter-name&gt<br>
    &ltfilter-class&gtedu.ucam.filters.MiFiltro&lt/filter-class&gt<br>
    &ltinit-param&gt <br>
    &ltparam-name&gttest&lt/param-name&gt<br>
    &ltparam-value&gttestValue&lt/param-value&gt<br>
    &lt/init-param&gt<br>
  &lt/filter&gt<br>
<br>
&ltfilter-mapping&gt<br>
    &ltfilter-name&gtMiFiltro&lt/filter-name&gt<br>
    &lturl-pattern&gt/*&lt/url-pattern&gt<br>
    &ltservlet-name&gtLoginServlet&lt/servlet-name&gt<br>
    &ltdispatcher&gtREQUEST&lt/dispatcher&gt<br>
  &lt/filter-mapping&gt<br>
</li>
</ul>
<br>

<u>¿Qu&eacute; podemos filtrar?</u><br/>
<ul>
<li>
<b>URL</b>. Se puede crear un filtro e indicarle mediante @WebFilter("/*") el patr&oacute;n de la URL que se debe cumplir para ejecutar el filtro. En la clase <i>edu.ucam.filters.FiltroTodo</i> se puede observar que se filtran todas las peticiones; mientras que en la clase <i>edu.ucam.filters.FiltroSecured</i> se puede ver que s&oacute;lo se filtran las peticiones que se dirijen a la URL <i>'/secured/*'</i><br>
<br>En este &uacute;ltimo caso, si no se ha hecho login y se intenta navegar hasta <a href="secured/listar.jsp">.../secured/listar.jsp</a> veréis que se muestra la pantalla de login.
</li>
<br>
<li>
<b>Tipo de petici&oacute;n</b>. En este caso lo que se filtran son los tipos de peticiones (REQUEST, ASYNC, FORWARD, INCLUDE o ERROR). Se ha creado el filtro <i>edu.ucam.filters.FiltroForward</i> que se ejecuta siempre que haya una petici&oacute;n de tipo FORWARD. Por ejemplo, al navegar hasta <a href="ServletForward">ServletForward</a>. 
</li>
<br>
<li>
<b>Servlet</b>. En este caso lo que se filtran son todas las peticiones que se dirijen a un servlet. Para ello, en la clase que implementa el servlet se le debe indicar un nombre al mismo mediante esta anotaci&oacute;n <i>@WebServlet(urlPatterns={"/ServletParaFiltrar"},name="ServletParaFiltrar")</i>. Y en la clase que implementa el filtro indicarle, con esta anotaci&oacute;n <i>@WebFilter(filterName = "FiltroServlet", servletNames = { "ServletParaFiltrar" })</i>, que debe filtrar dicho servlet.
<br><br>
Se ha creado el filtro <i>edu.ucam.filters.FiltroServlet</i> donde se puede ver en ejecución. 
</li>
</ul> 
<br>
<u>¿C&oacute;mo se implementa en eclipse?</u><br/><br/>
Al igual que con los servlets, botón drecho sobre <i>src</i> y <i>New -> Filter...</i> Se indica paquete y nombre y... ya está.
</body>
</html>