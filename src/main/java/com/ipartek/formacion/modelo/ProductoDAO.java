package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface ProductoDAO<P> extends CrudAble<Producto> {
	
	ArrayList<Producto> readByNombre(String nombre) throws Exception;
}
