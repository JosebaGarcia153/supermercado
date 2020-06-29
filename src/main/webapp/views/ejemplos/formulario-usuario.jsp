<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page ="../../includes/cabecera.jsp">
	<jsp:param name="pagina" value="FormularioUsuario" />
	<jsp:param name="title" value="FormularioUsuario" />
</jsp:include>

	<a href="index.jsp">VOLVER</a>
	<h1>Formulario para crear / editar usuario</h1>
	<p>${mensaje}</p>
	<div class="row">
		<div class="col">
			<form action="usuario-crear" method="post">
				<div class="form-group">
					<label for="id">ID:</label>
					<input type="text" name="id" id="id" value="${usuario.id}" readonly class="form-control">
				</div>
				
				<div class="form-group">
					<label for="rol">Rol:</label>
					<input type="text" name="rol" id="rol" value="${usuario.idRol}" readonly class="form-control">
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${usuario.nombre}" class="form-control" placeholder="Escribe el nombre del usuario">
				</div>
				
				<c:if test="${ usuario.id == 0}">
					<div class="form-group">
						<label for="pass">Contraseña:</label>
						<input type="password" name="pass" id="pass" value="${usuario.contrasenia}" class="form-control" >
					</div>
				</c:if>	
				
				<c:if test="${ usuario.id != 0}">
		
			<div class="accordion mb-4" id="accordionExample">
			  <div class="card">
			  
			    <div class="card-header" id="headingOne">
			      <h2 class="mb-0">
			        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			          Resetear Contraseña
			        </button>
			      </h2>
			    </div>
			
			    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
			      <div class="card-body">
			        <input type="password" id="pass" name="passNuevo" class="form-control" placeholder="Nueva Contraseña">
					<input type="password" id="repass" name="passNuevoConfirmacion" class="form-control"  placeholder="Repitela para confirmar" >		
			      </div>
			    </div>	    
			  </div><!-- /.card -->	  
			</div><!--  accordion -->
			</c:if>
				
				<input type="submit" value="Guardar">
			</form>
		</div>
	</div>

<%@include file="../../includes/pie.jsp" %>