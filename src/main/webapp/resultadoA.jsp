<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Cookies</title>
</head>
<body>
	<h1>Mostrar Cookies</h1>
	<p>Tu nombre es: ${cookie['cNombre'].value}</p>
	<p>Tu color favorito es: ${cookie['cColor'].value}</p>
</body>
</html>