package com.ipartek.formacion;

import java.sql.*;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Producto;

public class ListarProductos {
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		final String URL = "jdbc:mysql://localhost/supermercado";
		final String USUARIO = "debian-sys-maint";
		final String PASS = "o8lAkaNtX91xMUcV";
//		final String SQL = "SELECT id, nombre FROM producto ORDER BY nombre ASC; ";
		final String SQL = "SELECT id, nombre FROM producto WHERE nombre LIKE ? ;";
		try {
			//Comprueba que tenemos el .jar de MySQL
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Existe el .jar para mysql");
			
			//Conectar a la based the datos de supermercado
			Connection conexion = DriverManager.getConnection(URL, USUARIO, PASS);
			System.out.println("Se ha realizado la conexion con exito");
			
			//Realizar una consulta
			PreparedStatement pst = conexion.prepareStatement(SQL);
			
			System.out.println("Write the name of a product to display:");
			String prod = keyboard.nextLine();
			//Los % son para decir que busque palabras que contengan la variable por ambos lados
			pst.setString(1, "%" + prod + "%");
			
			ResultSet rs = pst.executeQuery();
			
			System.out.println("Listar producto");
			System.out.println("-------------------------------");
			
			//TODO pedir el nombre del producto a insertar por pantalla
			
			
			while (rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					
					Producto p = new Producto(nombre);
					p.setId(id);
					
					System.out.println(p);			
			}
			
			//Consultar de 1 en 1 los resultados hasta que no queden registros
			
//			while (rs.next()) {
//				
//				int id = rs.getInt("id");
//				String nombre = rs.getString("nombre");
//				
//				Producto p = new Producto(nombre);
//				p.setId(id);
//				
//				System.out.println(p);
//			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		System.out.println("Listado de productos");
	}
}
