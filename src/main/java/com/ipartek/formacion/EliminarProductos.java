package com.ipartek.formacion;

import java.sql.*;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;

public class EliminarProductos {

	public static void main(String[] args) {

		final String SQL = "DELETE FROM producto WHERE id = ?; ";
		boolean check = false;
		
		try ( 
				Scanner keyboard = new Scanner(System.in);
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);
				){
			
			ListarProductos.main(args);
			
			System.out.println("Eliminar producto");
			System.out.println("-------------------------------");			
			
			do {	
				try {
					check = false;
					
					System.out.println("Escribe el ID del producto a eliminar:");
					int idProd = Integer.parseInt(keyboard.nextLine());
					
					pst.setInt(1, idProd);
					
					//affectedRows es el numero de registros insertados
					int affectedRows = pst.executeUpdate();

					if (affectedRows == 1) {
						System.out.println("El producto ha sido eliminado.");
						check = true;
						
						ListarProductos.main(args);
					}
				} catch (NumberFormatException e) {

					System.out.println("Tienes que insertar un numero de ID valido.");

				} catch (SQLException e) {

					System.out.println("El ID del producto no existe en la base de datos.");
				} 
			} while (check == false);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}