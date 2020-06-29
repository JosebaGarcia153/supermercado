<%@page import="com.ipartek.formacion.modelo.Producto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<jsp:include page ="../../includes/cabecera.jsp">
	<jsp:param  name="pagina" value="tabla-p" />
	<jsp:param name="title" value="Tabla de Productos" />
</jsp:include>

	<h1>Tabla con Productos</h1>

	<%
		// Podemos usar el ${}  "EL" - "Expresion Language" en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>

	<table id="table">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Precio</td>
				<td>Imagen</td>
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
					<td>${p.precio}</td>
					<td><img src="${p.imagen}" class="img-thumbnail" alt="imagen"></td>
					<td>
						<a href="producto?id=${p.id}"><i class="fas fa-edit fa-lg"></i></a>
						<a href="producto-eliminar?id=${p.id}"><i class="fas fa-trash fa-lg"></i></a>	
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<%@include file="../../includes/pie.jsp" %>