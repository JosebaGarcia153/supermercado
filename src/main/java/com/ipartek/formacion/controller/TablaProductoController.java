package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.Producto;
import com.ipartek.formacion.modelo.ProductoDAOImpl;

/**
 * Servlet implementation class TablaAlumnoController
 */
@WebServlet("/ver-tabla-producto")
public class TablaProductoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//conseguir los alumnos de la base de datos
		
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		ArrayList<Producto> productos = dao.readAll();
		
		//enviar la informacion a la vista
		request.setAttribute("productos",  productos);
		
		
		//ir a la nueva vista o jsp
		request.getRequestDispatcher("views/ejemplos/tabla-producto.jsp").forward(request, response);
	}

}
