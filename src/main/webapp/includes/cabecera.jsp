<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
            <li class="nav-item ${ ( 'tabla-a' eq param.pagina ) ? 'active' : '' }">
              <a class="nav-link" href="ver-tabla-alumnos">Tabla Alumnos</a>
            </li>
            <li class="nav-item ${ ( 'tabla-p' eq param.pagina ) ? 'active' : '' }">
                <a class="nav-link" href="ver-tabla-producto">Tabla Producto</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.html">Iniciar Sesión</a>
            </li>
            
          </ul>
        
        </div>
      </nav>
      
      <main role="main" class="container mb-3">