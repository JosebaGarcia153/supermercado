package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class ProductoEliminarController
 */
@WebServlet("/usuario-eliminar")
public class UsuarioEliminarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		String mensaje = "";
		
		try {
			Usuario u = dao.delete(id);
			mensaje = "Eliminado " + u.getNombre();
			
		} catch (Exception e) {
			
			mensaje = "Error " + e.getMessage();
			e.printStackTrace();
			
		} finally {
			
			ArrayList<Usuario> usuarios = dao.readAll();
			request.setAttribute("usuarios",  usuarios);
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("views/ejemplos/tabla-usuarios.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
