<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guardar Cookies</title>
</head>
<body>
	<h1>Guardar Cookies</h1>
	<form action="apartado-a" method="post">

		<input type="text" name="nombre" placeholder="Escribe tu Nombre">
		<br/>
	
		<label for="color">Elije tu color favorito:</label>
        <select name="color" id="color">
            <option value="az">Azul</option>
            <option value="ro">Rojo</option>
            <option value="ve" selected>Verde</option>
        </select>
        <br/>
		<input type="submit" value="Guardar Cookies">
	</form>
</body>
</html>