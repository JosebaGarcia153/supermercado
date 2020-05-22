<%@page import="com.ipartek.formacion.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
td {
	border: 1px solid black
}
</style>
</head>
<body>
	<
	<a href="index.jsp">VOLVER</a>

	<h1>Tabla con Productos</h1>

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>

	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Operaciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td>
					<%
						// no hace falta usar el getter p.id == p.getId()
					%>
					<td>${p.nombre}</td>
					<td><a href="producto-eliminar?id=${p.id}">ELIMINAR</a>
						<a href="producto?id=${p.id}">EDITAR</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>