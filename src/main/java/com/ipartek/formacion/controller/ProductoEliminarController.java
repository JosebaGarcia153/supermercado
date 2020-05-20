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
 * Servlet implementation class ProductoEliminarController
 */
@WebServlet("/producto-eliminar")
public class ProductoEliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoEliminarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);
		
		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		String mensaje = "";
		
		try {
			Producto p = dao.delete(id);
			mensaje = "Eliminado " + p.getNombre();
			
		} catch (Exception e) {
			mensaje = "Error " + e.getMessage();
			e.printStackTrace();
		}
		
		ArrayList<Producto> productos = dao.readAll();
		request.setAttribute("producto",  productos);
		request.getRequestDispatcher("tabla-producto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);
	}

}