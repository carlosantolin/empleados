<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Empleado</title>
        <link rel="stylesheet" href="/timesheet-app/resources/style.css" type="text/css">
</head>
<body>
<h2>Añade un nuevo empleado</h2>
<div id="list">
        <sf:form method="post" action="empleados">
<ul>
    <li>
                    <label for="nombre">Nombre:</label>
                    <input name="nombre" id="nombre" value="${empleado.nombre}"/></li>
    <li>
                    <label for="departamento">Departamento:</label>
                    <input name="departamento" id="departamento"
                           value="${empleado.departamento}" /></li>
    <li>
                    <input type="submit" value="Guardar" id="guardar" /></li>
</ul>
</sf:form></div>
<a href="empleados">Ir atrás</a>
</body>
</html>