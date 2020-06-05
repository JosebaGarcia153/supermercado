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
	<h1>Formulario para crear / editar usuario</h1>
	<p>${mensaje}</p>
	<div class="row">
		<div class="col">
			<form action="usuario-crear" method="post">
				<div class="form-group">
					<label for="id">ID:</label>
					<input type="text" name="id" id="id" value="${usuario.id}" readonly >
				</div>
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${usuario.nombre}" placeholder="Escribe el nombre del usuario">
				</div>		
				
				<input type="submit" value="Guardar">
			</form>
		</div>
	</div>
</body>
</html>