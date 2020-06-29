<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Cookies</title>
</head>
<body>
	<h1>Mostrar Sesion</h1>
	<p>Tu nombre es: ${sNombre}</p>
	<p>Tu fecha de inicio de sesion es: ${sFecha}</p>
	<p>Tu navegador es: ${uAgent}</p>
</body>
</html>