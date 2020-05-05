package com.ipartek.formacion;

import java.sql.*;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class InsertarProductos {

	public static void main(String[] args) {

		final String SQL = "INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1); ";
		boolean check = false;
		
		try ( 
				Scanner keyboard = new Scanner(System.in);
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL);
				){
			
			

			System.out.println("Insertar producto");
			System.out.println("-------------------------------");			

			do {	
				try {
					check = false;
					
					System.out.println("Escribe el nombre del producto a insertar:");
					String prod = keyboard.nextLine();

					//Cambiamos el primer ? de la SQL por galletitas saladas
					//INSERT INTO producto ( nombre, id_usuario ) VALUES ( ? , 1);"
					pst.setString(1, prod);
					
					//affectedRows es el numero de registros insertados
					//executeUpdate siempre se usa con INSER, UPDATE y DELETE y devuelve un int de las filas aceptadas
					int affectedRows = pst.executeUpdate();
					

					if (affectedRows == 1) {
						System.out.println("Numero de registros creados " + affectedRows);
						check = true;
						
						ListarProductos.main(args);
					}
					
				} catch (MySQLIntegrityConstraintViolationException e) {
					
					System.out.println("El nombre ya existe en la base de datos.");
				} 
			} while (check == false);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}