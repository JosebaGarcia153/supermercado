<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Todas las rutas relativas comienzan por el href indicado -->
    <!--  ${pageContext.request.contextPath} == http://localhost:8080/AppSupermercado -->
    <base href="${pageContext.request.contextPath}/" />
    
    <!-- fontawesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
 
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    
    <!-- DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/styles.css">
     
    <title> ${param.title} | Supermercado</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <!-- logo -->
        <a class="navbar-brand" href="index.jsp">
            <i class="fas fa-shopping-cart"></i>
        </a>

        <!-- icono para desplegar menu en moviles -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <!-- lista enlaces -->
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item" ${ ( 'inicio' eq param.pagina ) ? 'active' : '' }>
              <a class="nav-link" href="index.jsp">Inicio</a>
            </li>
            <c:if test="${ not empty usuario_login }">
            	<li class="nav-item ${ ( 'tabla-u' eq param.pagina ) ? 'active' : '' }">
            		<a class="nav-link" href="ver-tabla-alumnos">Alumnos</a>
            	</li>
            	<li class="nav-item">
              		<a class="nav-link ${ ( 'tabla-p' eq param.pagina ) ? 'active' : '' } "  href="ver-tabla-producto">Productos</a>
            	</li>
            </c:if>	
            
          </ul>
          
          TOSTRING => ${usuario_login}
          
          <span class="form-inline">
         	<c:if test="${ empty usuario_login }">
            	  <a class="nav-link  btn btn-outline-warning" href="views/ejemplos/login.jsp">Iniciar Sesión</a>
            </c:if>
            
            <c:if test="${ not empty usuario_login }">
            	<span class="badge badge-pill badge-light mr-3">${usuario_login.nombre}</span>
            	<a class="nav-link  btn btn-outline-light" href="logout">Cerrar Sesión</a>
            </c:if>     
         </span>
        
        </div>
      </nav>
      
      <main role="main" class="container mb-3">
      
      	<jsp:include page="alerta.jsp"></jsp:include>
      	
      	<!-- 
      		cuidado porque esto lo incluye en funcion de la URL en la que estamos
      	     < jsp : include page="alerta.jsp"></ jsp : include> 
      	-->