<%@page import="com.ipartek.formacion.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<jsp:include page ="includes/cabecera.jsp">
	<jsp:param  name="pagina" value="tabla-a" />
	<jsp:param name="title" value="Tabla de Alumnos" />
</jsp:include>


<h1>Tabla con Alumnos</h1>

<style>
	td { border:1px solid black }
</style>

<%
	//recogemos la informacion "atributo" enviado desde el controlador
	ArrayList<Usuario> alumnos = (ArrayList<Usuario>)request.getAttribute("alumnos");


%>

<table id="table">	
	<thead>
		<tr>
			<th>id</th>
			<th>Nombre</th>
		</tr>
	</thead>
	
	<tbody>
	<% for( Usuario u : alumnos ){ %>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getNombre()%></td>
		</tr>
	<% } %>
	</tbody>
</table>

<%@include file="includes/pie.jsp" %>