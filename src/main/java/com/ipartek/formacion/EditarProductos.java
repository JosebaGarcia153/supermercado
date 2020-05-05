package com.ipartek.formacion;

import java.sql.*;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class EditarProductos {

	public static void main(String[] args) {

		final String SQL = "UPDATE producto SET nombre = ? WHERE id = ?; ";
		boolean check = false;

		try ( 
				Scanner keyboard = new Scanner(System.in);
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);
				){
			
			ListarProductos.main(args);
			
			System.out.println("Editar producto");
			System.out.println("-------------------------------");			
			
			do {	
				try {
					check = false;
					
					System.out.println("Escribe el ID del producto a editar:");
					int idProd = Integer.parseInt(keyboard.nextLine());
					
					System.out.println("Escribe el nuevo nombre del producto:");
					String prod = keyboard.nextLine();
					
					pst.setString(1, prod);
					pst.setInt(2, idProd);
					
					//affectedRows es el numero de registros insertados
					int affectedRows = pst.executeUpdate();

					if (affectedRows == 1) {
						System.out.println("El producto ha sido editado.");
						check = true;
						
						ListarProductos.main(args);
					}
				} catch (NumberFormatException e) {

					System.out.println("Tienes que insertar un numero de ID valido.");
				
				} catch (MySQLIntegrityConstraintViolationException e) {
					
					System.out.println("El nombre ya existe en la base de datos.");
					
				}  catch (SQLException e) {

					System.out.println("El ID del producto no existe en la base de datos.");
				} 
			} while (check == false);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}