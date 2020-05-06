package com.ipartek.formacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

public class GestionUsuarios {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		pintarMenu();	
	}
	
	private static void pintarMenu() {
		
		int opciones = 0;
		
		do {
			
			try {
				
				opciones = instrucciones();
				
				switch (opciones) {
				
					case 1:
						insertarUsuario();
						break;
				
					case 2:
						listarUsuarios();
						break;
						
					case 3:
						buscarUsuarioPorId();
						break;
						
					case 4:
						buscarUsuarioPorNombre();
						break;
						
					case 5:
						editarUsuario();
						break;
						
					case 6:
						borrarUsuario();
						break;
						
					case 7:
						System.out.println("El programa ha sido cerrado");
						keyboard.close();
						break;
					
					default:
						System.out.println("Numero invalido.");
						break;
				}
		
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
		} while (opciones != 7);
	}
	
	
	private static void insertarUsuario() throws Exception {

		try {

			UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();

			Usuario u = new Usuario();

			System.out.println("Escribe el nombre del usuario a insertar:");
			String nombre = keyboard.nextLine();

			u.setNombre(nombre);

			System.out.println("Insertar usuario");
			System.out.println("-------------------------------");	

			u = dao.create(u);

			System.out.println("Usuario creado");
			System.out.println("--------------------------------------");

			System.out.println(u);

		} catch (Exception e) {

			throw new Exception (e.getMessage());
		}
	}

	
	private static void listarUsuarios() throws Exception {
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		
		System.out.println("Listar usuarios");
		System.out.println("-------------------------------");

		ArrayList<Usuario> usuarios = dao.readAll();

		System.out.println("Listado de usuarios");
		System.out.println("--------------------------------------");

		for (Usuario u : usuarios) {
			
			System.out.println(u);
		}
	}

	
	private static void buscarUsuarioPorId() throws Exception {

		try {
			
			UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
			
			System.out.println("Escribe la ID del usuario a buscar:");
			int id = Integer.parseInt(keyboard.nextLine());

			System.out.println("Buscar usuario");
			System.out.println("-------------------------------");

			Usuario u = dao.readById(id);

			System.out.println("Listado de usuarios");
			System.out.println("--------------------------------------");

			System.out.println(u);

		} catch (NumberFormatException e) {

			System.out.println("Tienes que insertar un numero de ID valido.");

		} catch (Exception e) {

			System.out.println(e.getMessage());		
		}
	}
	
	
	private static void buscarUsuarioPorNombre() throws Exception {

		try {

			UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();

			System.out.println("Escribe el nombre de los usuarios a buscar:");
			String nombre = keyboard.nextLine();

			System.out.println("Buscar usuarios");
			System.out.println("-------------------------------");

			ArrayList<Usuario> usuarios = dao.readByName(nombre);

			System.out.println("Listado de usuarios");
			System.out.println("--------------------------------------");
			
			for (Usuario u : usuarios) {
				
				System.out.println(u);
			}
			

		} catch (Exception e) {

			System.out.println(e.getMessage());		
		}
	}


	private static void editarUsuario() throws Exception {

		try {

			UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();

			Usuario u = new Usuario();

			System.out.println("Escribe el ID del usuario a editar:");
			int id = Integer.parseInt(keyboard.nextLine());

			System.out.println("Escribe el nuevo nombre del usuario:");
			String nombre = keyboard.nextLine();

			u.setId(id);
			u.setNombre(nombre);

			System.out.println("Editar usuario");
			System.out.println("-------------------------------");

			u = dao.update(u);

			System.out.println("Usuario editado");
			System.out.println("--------------------------------------");

			System.out.println(u);

		} catch (NumberFormatException e) {

			System.out.println("Tienes que insertar un numero de ID valido.");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	
	private static void borrarUsuario() throws Exception {
		
		try {

			UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();

			Usuario u = new Usuario();

			System.out.println("Escribe el ID del usuario a eliminar:");
			int id = Integer.parseInt(keyboard.nextLine());

			System.out.println("Eliminar usuario");
			System.out.println("-------------------------------");

			u = dao.delete(id);

			System.out.println("Usuario eliminado");
			System.out.println("--------------------------------------");

			System.out.println(u);

		} catch (NumberFormatException e) {

			System.out.println("Tienes que insertar un numero de ID valido.");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	private static int instrucciones() throws Exception {
		
		int opciones = 0;
		
		System.out.println("Selecciona uno de los siguientes comandos:"
							+ "\n 1) Insertar usuario"
							+ "\n 2) Listar Usuarios"
							+ "\n 3) Buscar usuario por ID"
							+ "\n 4) Buscar usuario por nombre"
							+ "\n 5) Editar usuario"
							+ "\n 6) Borrar usuario"
							+ "\n 7) Cerrar el programa");
		
		try {
			opciones = Integer.parseInt(keyboard.nextLine());
			
		} catch (Exception e) {
			
			System.out.println("Tienes que insertar un numero de comando valido");
		}
		

		return opciones;	
	}
	
}
