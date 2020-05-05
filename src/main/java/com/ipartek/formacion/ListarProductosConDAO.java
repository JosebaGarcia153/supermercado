package com.ipartek.formacion;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

public class ListarProductosConDAO {
	
	public static void main(String[] args) {
				
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		
		System.out.println("Listar productos");
		System.out.println("-------------------------------");
		
		ArrayList<Producto> productos = dao.readAll();
		
		System.out.println("Listado de productos");
		System.out.println("--------------------------------------");

		for (Producto p : productos) {
			System.out.println(p);
		}
	}
}
