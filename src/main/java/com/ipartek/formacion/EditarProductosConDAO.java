package com.ipartek.formacion;

import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

public class EditarProductosConDAO {

	public static void main(String[] args) {

		try ( Scanner keyboard = new Scanner(System.in); ) {

			ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
			
			Producto p = new Producto();

			System.out.println("Escribe el ID del producto a editar:");
			int id = Integer.parseInt(keyboard.nextLine());

			System.out.println("Escribe el nuevo nombre del producto:");
			String nombre = keyboard.nextLine();

			p.setId(id);
			p.setNombre(nombre);
			
			System.out.println("Editar producto");
			System.out.println("-------------------------------");
			
			p = dao.update(p);

			System.out.println("Producto editado");
			System.out.println("--------------------------------------");

			System.out.println(p);

		} catch (NumberFormatException e) {

			System.out.println("Tienes que insertar un numero de ID valido.");
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
	}
}