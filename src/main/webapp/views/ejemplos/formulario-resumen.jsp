<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp">VOLVER AL INDEX</a>
	
	<h1>Mostrar Resumen CV</h1>
	
	<p>Atributo recibido desde el controlador</p>
	
	
	<p style="color: red;">${mensaje}</p>

    <hr>

    <h3>Name: </h3><p>${nombre}</p>
    <h3>Apellido: </h3>${apellido}	
 	<h3>Contrasenia: </h3>${contrasenia}	
    <h3>Edad: </h3>${edad}	
 	<h3>DNI: </h3>${dni}	
 	<h3>Sexo: </h3>${sexo}
    <h3>Horas: </h3>
    <%
        ArrayList<String> horas = (ArrayList<String>) request.getAttribute("horas");    
        for (String horario : horas) {
    %> 
  		  <p><%=horario%></p>
    <%
    }
    %>
    <h3>Estudios: </h3>${estudios}
    <h3>Comentarios: </h3>${comentarios}
	
</body>
</html>