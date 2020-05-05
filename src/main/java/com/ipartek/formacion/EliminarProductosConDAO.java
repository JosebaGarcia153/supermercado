package com.ipartek.formacion;

import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

public class EliminarProductosConDAO {

	public static void main(String[] args) {
		
		try ( Scanner keyboard = new Scanner(System.in); ) {

			ProductoDAOImpl dao = ProductoDAOImpl.getInstance();

			Producto p = new Producto();

			System.out.println("Escribe el ID del producto a eliminar:");
			int id = Integer.parseInt(keyboard.nextLine());
			
			System.out.println("Eliminar producto");
			System.out.println("-------------------------------");
			
			p = dao.delete(id);

			System.out.println("Producto eliminado");
			System.out.println("--------------------------------------");

			System.out.println(p);

		} catch (NumberFormatException e) {

			System.out.println("Tienes que insertar un numero de ID valido.");
		
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
}