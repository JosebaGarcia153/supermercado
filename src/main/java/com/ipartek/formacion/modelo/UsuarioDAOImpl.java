package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDAOImpl implements UsuarioDAO<Usuario> {
	
private static UsuarioDAOImpl instance = null;
	
	private UsuarioDAOImpl() {
		super();	
	}
	
	public static synchronized UsuarioDAOImpl getInstance() {
		
		if (instance == null) {
			
			instance = new UsuarioDAOImpl();
		}	
		return instance;
	}
	//executeQuerys => ResultSet
	private final String SQL_READ_ALL = "SELECT id, nombre, contrasenia, id_rol FROM usuario ORDER BY id DESC; ";
	private final String SQL_READ_BY_ID = "SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE id = ?; ";
	private final String SQL_READ_BY_NAME = "SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE nombre LIKE ?; ";
	private final String SQL_EXISTE = "SELECT id, nombre, contrasenia, id_rol FROM usuario WHERE nombre = ? AND contrasenia = ?; ";
	
	//executeUpdate => int
	private final String SQL_CREATE = "INSERT INTO usuario(nombre, contrasenia, id_rol) VALUES( ? ,'123456',1 ); ";
	private final String SQL_UPDATE = "UPDATE usuario SET nombre = ?, contrasenia = ? WHERE id = ?; ";
	private final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?; ";
	
	@Override
	public ArrayList<Usuario> readAll() {
		
		ArrayList<Usuario> registro = new ArrayList<Usuario>();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_READ_ALL);
				ResultSet rs = pst.executeQuery();
				){

			while (rs.next()) {

				registro.add(mapper(rs));		
			}						
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return registro;
	}

	@Override
	public Usuario readById(int id) throws Exception {
		
		Usuario u = new Usuario();

		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_READ_BY_ID);
				){

			pst.setInt(1, id);

			try ( ResultSet rs = pst.executeQuery() ){

				if (rs.next()) {

					u = mapper(rs);

				} else {

					throw new Exception ("No se pudo encontrar el registro de id = " + id);
				}
			}	
		}
		return u;
	}
	
	
	@Override
	public ArrayList<Usuario> readByName(String nombre) throws Exception {
		
		ArrayList<Usuario> registro = new ArrayList<Usuario>();

		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_READ_BY_NAME);
				){

			pst.setString(1, "%" + nombre + "%");

			try ( ResultSet rs = pst.executeQuery() ){

				if (rs.next()) {

					registro.add(mapper(rs));

				} else {

					throw new Exception ("No se pudo encontrar el registro de nombre = " + nombre);
				}
			}	
		}
		return registro;
	}
	
	
	@Override
	public Usuario create(Usuario u) throws Exception {

		if (u.getNombre() == null) {

			throw new Exception("No se ha insertado un nombre de usuario.");
		}

		try ( 
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
				){
			
			pst.setString(1, u.getNombre());

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				
				System.out.println("Numero de registros creados " + affectedRows);
				
				try ( ResultSet rsKeys = pst.getGeneratedKeys(); ) {
					
					if (rsKeys.next()) {

						u.setId(rsKeys.getInt(1));

					}
				}
			} else {

				throw new Exception ("No se pudo crear el registro para nombre = " + u.getNombre());
			}

		} catch (SQLException e) {

			throw new SQLException("El nombre ya existe en la base de datos. Inserta otro diferente.");
		}

		return u;
	}

	@Override
	public Usuario update(Usuario user) throws Exception {
		
		if (user.getNombre() == null) {
			
			throw new Exception("No se ha insertado un nombre de usuario.");
		}
		
		try ( 
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_UPDATE);
				){
			
			pst.setString(1, user.getNombre());
			pst.setString(2, user.getContrasenia());
			pst.setInt(3, user.getId());

			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				
				throw new Exception ("No se pudo editar el registro de id = " + user.getId());
			}
			
		} catch (SQLException e) {

			throw new SQLException("El nombre " + user.getNombre() + " ya existe en la base de datos.");

		} 
		return user;
	}
	
	@Override
	public Usuario delete(int id) throws Exception {
		
		Usuario u = new Usuario();
		
		try (
				Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE);
				){		

			pst.setInt(1, id);
			
			u = readById(id);
			
			int affectedRows = pst.executeUpdate();

			if (affectedRows != 1) {
				
				throw new Exception ("No se pudo eliminar el registro de id = " + id);
			}
		}
		return u;
	}

	@Override
	public Usuario existe(String nombre, String password) {
		
		Usuario usuario = null;
		
		try(	Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_EXISTE);	
				) {
			
			pst.setString(1, nombre);
			pst.setString(2, password);
			
			System.out.println("SQL = " + pst);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				if (rs.next()) {
					usuario = mapper(rs);
				}
			} //2nd try
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	private Usuario mapper( ResultSet rs ) throws SQLException {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setContrasenia( rs.getString("contrasenia"));
		usuario.setIdRol( rs.getInt("id_rol"));
		
		return usuario;
		
	}
}
