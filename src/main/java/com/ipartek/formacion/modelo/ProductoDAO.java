package com.ipartek.formacion.modelo;

import java.util.ArrayList;

public interface ProductoDAO<P> {
	
	P create( P prod )  throws Exception;
	
	ArrayList<P> readAll();
	
	P readById(int id) throws Exception;
	
	P update ( P prod )  throws Exception;
	
	P delete(int id)  throws Exception;
}
