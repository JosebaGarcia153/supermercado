package com.ipartek.formacion;

import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

public class InsertarProductosConDAO {

	public static void main(String[] args) {

		try ( Scanner keyboard = new Scanner(System.in); ) {
			
			ProductoDAOImpl dao = ProductoDAOImpl.getInstance();

			Producto p = new Producto();
			
			System.out.println("Escribe el nombre del producto a insertar:");
			String nombre = keyboard.nextLine();
			
			p.setNombre(nombre);
			
			System.out.println("Insertar producto");
			System.out.println("-------------------------------");	
			
			p = dao.create(p);

			System.out.println("Producto creado");
			System.out.println("--------------------------------------");

			System.out.println(p);

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} 
	}
}