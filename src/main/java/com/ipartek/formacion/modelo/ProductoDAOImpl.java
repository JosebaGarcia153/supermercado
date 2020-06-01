package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	private final String SQL_CREATE = "INSERT INTO producto (nombre, precio, imagen, id_usuario) VALUES ( ?, ?, ?, 1); ";
	private final String SQL_READ_ALL = "SELECT id, nombre, precio, imagen FROM producto ORDER BY nombre ASC; ";
	private final String SQL_READ_BY_ID = "SELECT id, nombre, precio, imagen FROM producto WHERE id = ? ;";
	private final String SQL_UPDATE = "UPDATE producto SET nombre = ?, precio = ?, imagen = ? WHERE id = ?; ";
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
				double precio = rs.getDouble("precio");
				String imagen = rs.getString("imagen");

				Producto p = new Producto(nombre);
				p.setId(id);
				p.setPrecio(precio);
				p.setImagen(imagen);

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
					double precio = rs.getDouble("precio");
					String imagen = rs.getString("imagen");
					
					
					p.setNombre(nombre);
					p.setId(id);
					p.setPrecio(precio);
					p.setImagen(imagen);
					
				} else {
					
					throw new Exception ("No se pudo encontrar el registro de id = " + id);
				}
			}	
		}
		return p;
	}

	@Override
	public Producto create(Producto prod) throws Exception {

		if (prod.getNombre() == null) {

			throw new Exception("No se ha insertado un nombre de producto.");
		}

		try ( 
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
				){
			
			pst.setString(1, prod.getNombre());
			pst.setDouble(2, prod.getPrecio());
			pst.setString(3, prod.getImagen());

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				
				System.out.println("Numero de registros creados " + affectedRows);
				
				//conseguir el ID
				try ( ResultSet rsKeys = pst.getGeneratedKeys(); ) {
					
					if (rsKeys.next()) {

						prod.setId(rsKeys.getInt(1));

					}
				}
			} else {

				throw new Exception ("No se pudo crear el registro para nombre = " + prod.getNombre());
			}

		} catch (SQLException e) {

			throw new SQLException("El nombre ya existe en la base de datos.");
		}

		return prod;
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
			pst.setDouble(2, prod.getPrecio());
			pst.setString(3, prod.getImagen());
			pst.setInt(4, prod.getId());

			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				
				throw new Exception ("No se pudo editar el registro de id = " + prod.getId());
			}
			
		} catch (SQLException e) {

			throw new SQLException("El nombre " + prod.getNombre() + " ya existe en la base de datos.");

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

			if (affectedRows != 1) {
				
				throw new Exception ("No se pudo eliminar el registro de id = " + id);
			}
		}
		return p;
	}

	@Override
	public ArrayList<Producto> readByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> readAllByPrice(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}
}
