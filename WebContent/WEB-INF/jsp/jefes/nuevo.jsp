<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Jefe</title>
        <link rel="stylesheet" href="/gestion/resources/estilos.css" type="text/css">
</head>
<body>
<h2>Añade un nuevo jefe</h2>
<div id="list">
        <sf:form method="post" action="jefes">
<ul>
    <li>
                    <label for="nombre">Nombre:</label>
                    <input name="nombre" id="nombre" value="${jefe.nombre}"/></li>

    <li>
                    <input type="submit" value="Guardar" id="guardar" /></li>
</ul>
</sf:form></div>
<a href="jefes">Ir atrás</a>
</body>
</html>