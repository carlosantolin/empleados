<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 
<html>
<head>
    <title>Bienvenido a la aplicacion de gestion!</title>
</head>
<body>

<h1>Bienvenido a la aplicacion de gestion!</h1>


<ul>
    <li><a href="jefes">Lista de jefes</a></li>
    <li><a href="empleados">Lista de empleados</a></li>
    <li><a href="tareas">Lista de tareas</a></li>
    <li><a href="horario">Lista de horarios</a></li>
</ul>


<h2>Echale un vistazo a <a href="tarea-servicio">servicios extras!</a></h2>
Hoy es: <fmt:formatDate value="${hoy}" pattern="dd-MM-yyyy" />
</body>
</html>