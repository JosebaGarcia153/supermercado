package com.ipartek.formacion.modelo;

import java.sql.*;

public class ConnectionManager {
	
	private final static String URL = "jdbc:mysql://localhost/supermercado";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Connection conexion = null;
		
		//Comprobar que tenemos el .jar para MySQL
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Existe el .jar para mysql");
		
		//Establecer conexion
		conexion = DriverManager.getConnection(URL, USUARIO, PASS);
		System.out.println("La conexion se ha realizado la conexion con exito");
		
		return conexion;
	}
}
