<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Producto</title>
</head>
<body>
	<a href="index.jsp">VOLVER</a>
	
	<c:if test="${not empty validacion}">
		<div style="padding:20px; background.color:#DDD; color:#000;">
			<ol>
				<c:forEach items="${validacion}" var="validar">
					<li>${validar}</li>
				</c:forEach>
			</ol>	
		</div>
	</c:if>
	
	<h1>Formulario para crear/modificar producto</h1>
	<p>${mensaje}</p>
	<form action="producto" method="post">
	
		<label for="id">ID:</label>
		<input type="text" name="id" id="id" value="${producto.id}" readonly >
		<br>
		
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre" placeholder="Escribe el nombre del producto">
		
		<input type="submit" value="Guardar">
	</form>
</body>
</html>