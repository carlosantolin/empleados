<%@ page isErrorPage="true" %>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 
 <html>
 <meta charset="UTF-8">
 <head>
    <title>Jefes</title>
        <link rel="stylesheet" href="/gestion/resources/estilos.css" type="text/css">
</head>
<body>
<h1>Lista de empleados</h1>
<a href="jefes?nuevo">Añadier nuevo jefe</a>
<table cellspacing="5" class="main-table">
<tr>
<th>Nombre</th>
<th>Detalles</th>
<th>Borrar</th>
</tr>
<c:forEach items="#{jefes}" var="j">
<tr>
<td>${j.nombre}</td>
<td>
                    <a href="jefes/${j.id}">Ir a detalle</a></td>
<td>

                    <sf:form action="jefes/borrar/${j.id}" method="post" cssClass="delete">
                        <input type="submit" class="delete-button" value="" />
                    </sf:form></td>
</tr>
</c:forEach></table>
<a href="bienvenido">Ir atrás</a>
</body>
</html>