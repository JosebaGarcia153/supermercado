package com.ipartek.formacion;

import java.sql.*;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.Producto;

public class ListarProductos {
	
	public static void main(String[] args) {
		
		final String SQL = "SELECT id, nombre FROM producto ORDER BY nombre ASC; ";	
		
		try (
				//Conectar a la base de datos de supermercado
				//Connection conexion = DriverManager.getConnection(URL, USUARIO, PASS);
				Connection conexion = ConnectionManager.getConnection();

				//Realizar una consulta
				PreparedStatement pst = conexion.prepareStatement(SQL);
				
				//executeQuerry se usa siempre que se hace un SELECT y devuelve los resultads del ResultSet
				ResultSet rs = pst.executeQuery();
				){
			
			System.out.println("Listar producto");
			System.out.println("-------------------------------");
			
			//Consultar de 1 en 1 los resultados hasta que no queden registros
			while (rs.next()) {
				
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					
					Producto p = new Producto(nombre);
					p.setId(id);
					
					System.out.println(p);			
			}						
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		System.out.println("Listado de productos");
	}
}
