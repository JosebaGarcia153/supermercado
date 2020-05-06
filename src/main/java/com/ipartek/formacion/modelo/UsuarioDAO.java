package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface UsuarioDAO<P> extends CrudAble<Usuario> {
	
	ArrayList<Usuario> readByName(String nombre) throws Exception;
}
