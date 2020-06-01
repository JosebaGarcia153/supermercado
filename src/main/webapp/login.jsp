<jsp:include page ="includes/cabecera.jsp">
	<jsp:param name="pagina" value="login" />
	<jsp:param name="title" value="Login" />
</jsp:include>

<form action="login" method="post">

	<input type="text" name="name" placeholder="Tu Nombre">
	<br/>
	<input type="password" name="pass" placeholder="Tu Contrasenia">
	<br/>
	<input type="submit" value="Iniciar sesion">
</form>

<%@include file="includes/pie.jsp" %>