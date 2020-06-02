<jsp:include page ="includes/cabecera.jsp">
	<jsp:param name="pagina" value="login" />
	<jsp:param name="title" value="Login" />
</jsp:include>

<form action="login" method="post">

	<input type="text" name="name" placeholder="Tu Nombre">
	<br/>
	<input type="password" name="pass" placeholder="Tu Contrasenia">
	<br/>
	
	<label for="lang">Idioma</label>
        <select name="lang" id="lang">
            <option value="es">Espaniol</option>
            <option value="en">Ingles</option>
            <option value="other" selected>Otro</option>
        </select>
        
	<input type="submit" value="Iniciar sesion">
</form>

<%@include file="includes/pie.jsp" %>