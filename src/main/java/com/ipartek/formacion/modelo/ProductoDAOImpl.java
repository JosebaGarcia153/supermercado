package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ProductoDAOImpl implements ProductoDAO<Producto> {
	
private static ProductoDAOImpl instance = null;
	
	private ProductoDAOImpl() {
		super();	
	}
	
	public static synchronized ProductoDAOImpl getInstance() {
		
		if (instance == null) {
			
			instance = new ProductoDAOImpl();
		}	
		return instance;
	}
	
	private final String SQL_CREATE = "INSERT INTO producto (nombre, id_usuario) VALUES ( ? , 1); ";
	private final String SQL_READ_ALL = "SELECT id, nombre FROM producto ORDER BY nombre ASC; ";
	private final String SQL_READ_BY_ID = "SELECT id, nombre FROM producto WHERE id = ? ;";
	private final String SQL_UPDATE = "UPDATE producto SET nombre = ? WHERE id = ?; ";
	private final String SQL_DELETE = "DELETE FROM producto WHERE id = ?; ";
	
	@Override
	public ArrayList<Producto> readAll() {
		
		ArrayList<Producto> registro = new ArrayList<Producto>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_READ_ALL);
				ResultSet rs = pst.executeQuery();
				){

			while (rs.next()) {

				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				Producto p = new Producto(nombre);
				p.setId(id);

				registro.add(p);		
			}						
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return registro;
	}

	@Override
	public Producto readById(int id) throws Exception {
		
		Producto p = new Producto();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_READ_BY_ID);
				){

			pst.setInt(1, id);

			try ( ResultSet rs = pst.executeQuery() ){

				if (rs.next()) {

					id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					
					p.setNombre(nombre);
					p.setId(id);
					
				} else {
					
					throw new Exception ("No se pudo encontrar el registro de = + id");
				}
			}	
		}
		return p;
	}

	@Override
	public Producto create(Producto prod) throws Exception {

		Producto p = new Producto();

		try ( 
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
				){
			
			pst.setString(1, prod.getNombre());

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				System.out.println("Numero de registros creados " + affectedRows);
				
				try ( ResultSet rsKeys = pst.getGeneratedKeys(); ) {
					
					if (rsKeys.next()) {
						
						p.setId(rsKeys.getInt(1));
					}	
				}
				p.setNombre(prod.getNombre());
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			System.out.println("El nombre ya existe en la base de datos.");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Producto update(Producto prod) throws Exception {
		
		if (prod.getNombre() == null) {
			
			throw new Exception("No se ha insertado un nombre de producto.");
		}
		
		try ( 
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);
				){
			
			pst.setString(1, prod.getNombre());
			pst.setInt(2, prod.getId());

			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				
				throw new Exception ("No se pudo eliminar el registro de =" + prod.getId());
			}
			
		} catch (SQLException e) {

			throw new SQLException("El nombre ya existe en la base de datos.");

		} 
		return prod;
	}
	
	@Override
	public Producto delete(int id) throws Exception {
		
		Producto p = new Producto();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);
				){		

			pst.setInt(1, id);
			
			p = readById(id);
			
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				
				System.out.println("El producto ha sido eliminado.");
			
			} else {
				
				throw new Exception ("No se pudo eliminar el registro de =" + id);
			}
		}
		return p;
	}
}
