<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No se pudo borrar el jefe</title>
</head>
<body>
    Ups,  El recurso <a href="/gestion/jefes/${empleado.id}">${jefe.nombre}</a> no pudo ser borrado.
        Por favor, asegurese de que el jefe no tenga ninguna tarea asignada ni horario activo.
 
 
<a href="/gestion/bienvenido">Página principal.</a>
</body>
</html>