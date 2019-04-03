<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>No se pudo borrar el empleado</title>
</head>
<body>
    Ups,  El recurso <a href="/gestion/empleados/${empleado.id}">${empleado.nombre}</a> no pudo ser borrado.
        Por favor, asegurese de que el empleado no tenga ninguna tarea asignada ni horario activo.
 
 
<a href="/gestion/bienvenido">Página principal.</a>
</body>
</html>