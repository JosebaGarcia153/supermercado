package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.UsuarioDAOImpl;
import com.ipartek.formacion.modelo.Usuario;

/**
 * Servlet implementation class UsuarioCrearController
 */
@WebServlet("/usuario-crear")
public class UsuarioCrearController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String parametroId = request.getParameter("id");

			Usuario usuario = new Usuario();

			if (parametroId != null) {

				int id = Integer.parseInt(parametroId);
				UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
				usuario = dao.readById(id);
			}

			request.setAttribute("usuario", usuario);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// ir a la nueva vista / jsp
			request.getRequestDispatcher("formulario-usuario.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		
		
		//Recoger los valores del formulario
		//El nombre del parametro debe coincidir con el atributo name del input <input type="text" name="nombre" placeholder="Escribe el nombre del producto">
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		
		String idParametro = request.getParameter("id");
		int id = Integer.parseInt(idParametro);
		
		String rolParametro = request.getParameter("rol");
		int rol = Integer.parseInt(rolParametro);
		
		// parametros para cambio contraseña
		String passNuevo = request.getParameter("passNuevo");
		String passNuevoConfirmacion = request.getParameter("passNuevoConfirmacion");
		
		//Settear parametros al pojo
		Usuario usuario = new Usuario();
		
		String mensaje = "";
		
		try {

			usuario.setNombre(nombre);
			usuario.setId(id);
			usuario.setIdRol(rol);
			
			if (id == 0) {
				
				usuario.setContrasenia(pass);
				dao.create(usuario);
				
			} else {
				
				if ( !"".equals(passNuevoConfirmacion) ) {
					
					if (passNuevo.equals(passNuevoConfirmacion)) {				
					
						// cambio de contraseña
						usuario.setContrasenia(passNuevo);
						
					} else {
						
						throw new Exception("Las contraseñas no coinciden");
					}
				} else {
					
					// mantener la contraseña y NO cambiarla
					// recupero usuario de la base datos para mantener su contraseña y no cambiarla 
					Usuario uGuardado = dao.readById(id);				
					usuario.setContrasenia(uGuardado.getContrasenia());
					
				}
				dao.update(usuario);
			}
			
		} catch (Exception e) {
			
			mensaje = "Lo sentimos pero hemos tenido una Excepcion: " + e.getMessage();
	 		e.printStackTrace();
		}
		
		//Enviar datos a la vista
		mensaje = "Datos guardados";
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("usuario", usuario);
		
		//Ir a la nueva vista/jsp
		request.getRequestDispatcher("formulario-usuario.jsp").forward(request,response);
	}
}
