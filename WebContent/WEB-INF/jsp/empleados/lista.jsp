<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 
 <html>
 <meta charset="UTF-8">
 <head>
    <title>Empleados</title>
        <link rel="stylesheet" href="/gestion/resources/estilos.css" type="text/css">
</head>
<body>
<h1>Lista de empleados</h1>
<a href="empleados?nuevo">Añadier nuevo empleado</a>
<table cellspacing="5" class="main-table">
<tr>
<th>Nombre</th>
<th>Departmento</th>
<th>Detalles</th>
<th>Borrar</th>
</tr>
<c:forEach items="#{empleados}" var="emp">
<tr>
<td>${emp.nombre}</td>
<td>${emp.departamento}</td>
<td>
                    <a href="empleados/${emp.id}">Ir a detalle</a></td>
<td>

<!-- 				Esto es necesario para permitir el uso del metodo DELETE a través de HTTP1, -->
<!-- 																			o eso dicen. -->
				
                    <sf:form action="empleados/${emp.id}" method="delete" cssClass="delete">
                        <input type="submit" class="delete-button" value="" />
                    </sf:form></td>
</tr>
</c:forEach></table>
<a href="bienvenido">Ir atrás</a>
</body>
</html>