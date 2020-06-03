package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface UsuarioDAO<P> extends CrudAble<Usuario> {
	
	ArrayList<Usuario> readByName(String nombre) throws Exception;
	
	//Busca el usuario en la base de datos, si no existe devuelve null
	Usuario existe (String nombre, String password);
}
