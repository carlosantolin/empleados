<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<meta charset="UTF-8">
<head>
    <title>Página de empleado</title>
        <link rel="stylesheet" href="/gestion/resources/estilo.css" type="text/css">
</head>
<body>
<h2>Info de empleado</h2>
<div id="list">
        <sf:form method="post">
<ul>
    <li>
                    <label for="nombre">Nombre:</label>
                    <input name="nombre" id="nombre" value="${empleado.nombre}" disabled="true"/></li>
    <li>
                    <label for="departamento">Departamento:</label>
                    <input name="departamento" id="departamento" value="${empleado.departamento}" disabled="true" /></li>
    <li>
                    <input type="button" value="Desbloquear" id="desbloquear" />
                    <input type="submit" value="Guardar" id="guardar" class="hidden" /></li>
</ul>
</sf:form></div>
<a href="../empleados">Ir atrás</a>
 
    <script src="/gestion/resources/jquery-1.7.1.js"></script>
    <script>
        (function() {
            $("#desbloquear").on("click", function() {
                $("#desbloquear").addClass("hidden"); //ver estilos.css
 
                // enable stuff
                $("#nombre").removeAttr("disabled");
                $("#departamento").removeAttr("disabled");
                $("#guardar").removeClass("hidden");
            });
        })();
    </script>
</body>
</html>