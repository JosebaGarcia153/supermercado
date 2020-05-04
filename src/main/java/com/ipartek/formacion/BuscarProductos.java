package com.ipartek.formacion;

import java.sql.*;
import java.util.Scanner;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;

public class BuscarProductos {
	
	public static void main(String[] args) {

		final String SQL = "SELECT id, nombre FROM producto WHERE nombre LIKE ? ;";
		
		try (
				Scanner keyboard = new Scanner(System.in);

				//Conectar a la base de datos de supermercado
				//conexion = DriverManager.getConnection(URL, USUARIO, PASS);
				Connection conexion = ConnectionManager.getConnection();

				//Realizar una consulta
				PreparedStatement pst = conexion.prepareStatement(SQL);

				){

			System.out.println("Write the name of a product to display:");
			String prod = keyboard.nextLine();

			//Los % son para decir que busque palabras que contengan la variable por ambos lados
			pst.setString(1, "%" + prod + "%");

			try ( ResultSet rs = pst.executeQuery() ){

				System.out.println("Buscar producto");
				System.out.println("-------------------------------");

				//Consultar de 1 en 1 los resultados hasta que no queden registros
				while (rs.next()) {
					
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");

					Producto p = new Producto(nombre);
					p.setId(id);

					System.out.println(p);	
					
				}//while
			}//try2
			
		} catch (Exception e) {   		//try1
			
			e.printStackTrace();
		}		
		System.out.println("Listado de productos");
	}
}
