<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<jsp:include page ="../../includes/cabecera.jsp">
	<jsp:param  name="pagina" value="tabla-u" />
	<jsp:param name="title" value="Tabla de Alumnos" />
</jsp:include>

<h1>Tabla con Usuarios</h1>

<table id="table">	
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Rol</th>
			<th>Operaciones</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${usuarios}" var="u">
		<tr>
			<td>${u.id}</td>
			<td>${u.nombre}</td>
			<td>${u.idRol}</td>
			<td>
				<a href="usuario-crear?id=${u.id}"><i class="fas fa-edit fa-lg"></i></a>
				<a href="usuario-eliminar?id=${u.id}"><i class="fas fa-trash fa-lg"></i></a>	
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@include file="../../includes/pie.jsp" %>