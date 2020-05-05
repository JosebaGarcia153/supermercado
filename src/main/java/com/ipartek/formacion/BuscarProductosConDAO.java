package com.ipartek.formacion;

import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

public class BuscarProductosConDAO {

	public static void main(String[] args) {

		try ( Scanner keyboard = new Scanner(System.in); ) {

			ProductoDAOImpl dao = ProductoDAOImpl.getInstance();

			System.out.println("Escribe la ID del producto a buscar:");
			int id = Integer.parseInt(keyboard.nextLine());
			
			System.out.println("Buscar producto");
			System.out.println("-------------------------------");
			
			Producto p = dao.readById(id);

			System.out.println("Listado de productos");
			System.out.println("--------------------------------------");

			System.out.println(p);

		} catch (NumberFormatException e) {

			System.out.println("Tienes que insertar un numero de ID valido.");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());		
		} 
	}
}
