<% // @include file="includes/cabecera.jsp" %>

<jsp:include page ="includes/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>

<h1>Pagina principal</h1>


<%
	//Esto es java
	out.print("Esta linea esta en java");
%>
<br/>

<a href="ver-tabla-usuarios">Ver usuarios en tabla</a><br/>
<a href="ver-tabla-producto">Ver productos en tabla</a><br/>
<a href="producto">Crear Producto</a><br/>
<a href="usuario-crear">Crear Usuario</a><br/>
<a href="getYpost.jsp">GET y POST</a><br/>
<a href="formulario.jsp">Ejemplo formulario completo</a><br/>
<a href="MiPrimerServlet?nombre=joseba&apellido=garcia&email=aaaaa">Mi Primer Servlet</a><br/>

<%@include file="includes/pie.jsp" %>


