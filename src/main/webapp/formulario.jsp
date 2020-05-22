<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">VOLVER</a>
	
	<h1>Formulario Completo</h1>
	
	<c:if test="${not empty validaciones}">
		<div style="padding:20px; background.color:#DDD; color:#000;">
			<ol>
				<c:forEach items="${validaciones}" var="validacion">
					<li>${validacion}</li>
				</c:forEach>
			</ol>	
		</div>
	</c:if>
	
	<form action="formulario-completo" method="post">
        
        <label for="nombre" class="obligatorio">Nombre</label>
        <input type="text" id ="nombre" name="nombre" value="${nombre}" size="20" maxlength="30" required autofocus />
        
        <br/>
        
        <label for="apellido" class="obligatorio">Apellido</label>
        <input type="text" id="apellidos" name="apellido" value="${apellido}" size="50" maxlength="30" required />
	
		<br/>
		
        <label for="contrasenia">Contrasenia</label><br/>
        <input type="password" id="contraseia" name="contrasenia" value="${contrasenia}" maxlength="10" placeholder="Minimo 3, maximo 6" pattern="[A-Za-z]{3. 6}"/>
        
        <br/>

        <label for="edad">Edad</label><br/>
        <input type="number" id="edad" step="1" placeholder="00-99" name="edad" value="${edad}" size="3" pattern="[1-9]+" min="1" max="99"/>
        
        <br/>
        
        <label for="dni">DNI</label> <br/>
        <input type="text" id="dni" name="dni" value="${dni}" size="10" minlength="9" maxlength="9" />
        
        <br/>

        <fieldset>
            <legend>Elije tu sexo:</legend>
            <label for="sexo">Sexo</label> <br/>
            <input type="radio" id="hombre" name="sexo" value="h" checked="checked" />
            <label for="hombre">Hombre</label> <br/>
            <input type="radio" id="mujer" name="sexo" value="m" />
            <label for="mujer">Mujer</label>
        </fieldset>

        <br/>

        <fieldset>
            <legend>Elije tus horas:</legend>

            <input type="checkbox" id="completo" name="horas" value="ft">
            <label for="completo">Tiempo completo</label><br>

            <input type="checkbox" id="parcial" name="horas" value="pt">
            <label for="parcial">Tiempo parcial</label><br>

            <input type="checkbox" id="todos" name="horas" value="all">
            <label for="todos">Todos</label><br>
        </fieldset>

        <br/>
<!--
        <label for="studios">Estudios</label>
        <select name="estudios" id="estudios">
            <option value="u">Universidad</option>
            <option value="p">Formacion Profesional</option>
            <option value="o" selected>Others</option>
        </select>
-->
		<label for="studios">Estudios</label>
        <select name="estudios" id="estudios">
            <option value="u" ${(estudios eq "u" ) ? "selected" : ""}>Universidad</option>
            <option value="p" ${(estudios eq "p" ) ? "selected" : ""}>Formacion Profesional</option>
            <option value="o" ${(estudios eq "o" ) ? "selected" : ""}>Others</option>
        </select>
        
        <br/><br/><br/>

        <label for="text">Comentarios:</label><br/>
        <textarea name="comentarios" id="text" cols="50" rows="10" placeholder="Comentarios"></textarea>

        
        <input type="submit" name="enviar" value="Enviar formulario" />
        <input type="reset" name="limpiar" value="Borrar los datos introducidos" />

	</form>
</body>
</html>