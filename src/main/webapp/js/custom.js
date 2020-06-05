// ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
$(document).ready(function() {
    // seleccion por id => #example y ejecuta el plugin .DataTable();
	$('#table').DataTable();
});

function cifrar() {
	
	console.log('cifrar y conseguir hash');

	//recupero la contraseña del input a traves de su ID
	var contrasenia = document.getElementById('pass').value;

	//consigo el hash mediante la libreria incluida en el pie.jsp
	var hash = md5(contrasenia);
	
	//guardo en el input el codigo hash
	document.getElementById('pass').value = hash;		
	
	//enviar formulario
	return true; // si ponemos false no se envia el formulario	
}