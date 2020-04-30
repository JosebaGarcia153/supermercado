package com.ipartek.formacion;

import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class InsertarProductos {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		final String URL = "jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
		final String SQL = "INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1); ";
		boolean check = false;
		
		do {
			check = false;
		try {
			//Comprueba que tenemos el .jar de MySQL
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el .jar para mysql");

			//Conectar a la based the datos de supermercado
			Connection conexion = DriverManager.getConnection(URL, USUARIO, PASS);
			System.out.println("Se ha realizado la conexion con exito");

			//Realizar una consulta
			PreparedStatement pst = conexion.prepareStatement(SQL);

			System.out.println("Insertar producto");
			System.out.println("-------------------------------");

			//TODO pedir el nombre del producto a insertar por pantalla
			System.out.println("Escribe el nombre del producto a insertar:");
			String prod = keyboard.nextLine();


			//Cambiamos el primer ? de la SQL por galletitas saladas
			//INSERT INTO producto ( nombre, id_usuario ) VALUES ( ? , 1);"
			pst.setString(1, prod);

			int affectedRows = pst.executeUpdate();
			//affectedRows es el numero de registros insertados
			
			if (affectedRows == 1) {
				System.out.println("Numero de registros creados " + affectedRows);
				check = true;
			}
		} 
		catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("El nombre ya existe en la base de datos.");
			
		} 
			
		catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		} while (check == false);
	}
}