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
 * Servlet implementation class ProductoCrearController
 */
@WebServlet("/producto")
public class ProductoGuardarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String parametroId = request.getParameter("id");

			Producto producto = new Producto();

			if (parametroId != null) {

				int id = Integer.parseInt(parametroId);
				ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
				producto = dao.readById(id);
			}

			request.setAttribute("producto", producto);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// ir a la nueva vista / jsp
			request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<String> validacion = new ArrayList<String>();

		ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
		Producto producto = new Producto();

		String mensaje = "";

		try {

			// Recoger los valores del formulario
			// El nombre del parametro debe coincidir con el atributo name del input <input
			// type="text" name="nombre" placeholder="Escribe el nombre del producto">
			String idParametro = request.getParameter("id");
			String nombreParametro = request.getParameter("nombre");
			String precioParametro = request.getParameter("precio");
			String imagenParametro = request.getParameter("imagen");

			if ("".equalsIgnoreCase(nombreParametro)) {

				validacion.add("Debes escribir un nombre");

			} else {

				int id = Integer.parseInt(idParametro);
				double precio = Double.parseDouble(precioParametro);

				producto.setId(id);
				producto.setNombre(nombreParametro);
				producto.setPrecio(precio);
				producto.setImagen(imagenParametro);
				

				if (id == 0) {
					
					for (Producto p : dao.readAll()) {
						
						if (p.getNombre().equalsIgnoreCase(nombreParametro)) {
							
							validacion.add("El producto ya existe");	
						}	
					}
					dao.create(producto);
					
				} else {

					dao.update(producto);
				}

				mensaje = "Producto guardado con exito";

			}
		} catch (Exception e) {

			//mensaje = "Lo sentimos pero hemos tenido una Excepcion: " + e.getMessage();
			e.printStackTrace();

		} finally {

			// Enviar datos a la vista
			// Ir a la nueva vista/jsp
			if (validacion.isEmpty()) {

				request.setAttribute("mensaje", mensaje);
				request.setAttribute("productos", dao.readAll());
				request.getRequestDispatcher("tabla-producto.jsp").forward(request, response);
				
			} else {
				
				request.setAttribute("validacion", validacion);
				request.setAttribute("producto", producto);
				request.getRequestDispatcher("formulario-producto.jsp").forward(request, response);
			}
		} // finally
	}// post
}
