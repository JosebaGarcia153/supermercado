<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Guardar Producto" /> 
</jsp:include>


	
	<h1>Formulario para crear/modificar producto</h1>
	<p>${mensaje}</p>
	<div class="row">
		<div class="col">
			<form action="producto" method="post">
				<div class="form-group">
					<label for="id">ID:</label>
					<input type="text" name="id" id="id" value="${producto.id}" readonly >
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${producto.nombre}" placeholder="Escribe el nombre del producto">
				</div>
				
				<div class="form-group">
					<label for="precio">precio:</label>
					<input type="text" name="precio" id="precio" value="${producto.precio}" class="form-control" placeholder="0.0 €" >
				</div>
				
				<div class="form-group">
					<label for="imagen">Imagen:</label>
					<input type="text" name="imagen" id="imagen" value="${producto.imagen}" class="form-control" placeholder="URL de la imagen (.jpg o .png)" >
				</div>
				
				<input type="submit" value="Guardar">
			</form>
		</div>
		
		<div class="col">
			<img src="${producto.imagen}" class="img-thumbnail" alt="imagen del producto a modificar">
		</div>
	</div>
	
<jsp:include page="includes/pie.jsp"  />