<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Usuario</title>
</head>
<body>
	<a href="index.jsp">VOLVER</a>
	<h1>Formulario para crear usuario</h1>
	<p>${mensaje}</p>
	<form action="usuario-crear" method="post">
	
		<input type="text" name="nombre" placeholder="Escribe el nombre del usuario">
		
		<input type="submit" value="crear">
	</form>
</body>
</html>