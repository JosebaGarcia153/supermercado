package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioCompletoController
 */
@WebServlet("/formulario-completo")
public class FormularioCompletoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.append("Served at: ");
		out.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> validaciones = new ArrayList<String>();
		
		try {
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String contrasenia = request.getParameter("contrasenia");
			String edad = request.getParameter("edad");
			String dni = request.getParameter("dni");
			String sexo = request.getParameter("sexo");
			String[] horas = request.getParameterValues("horas");
			String estudios = request.getParameter("estudios");
			String comentarios = request.getParameter("comentarios");
			
			
			if ("".equalsIgnoreCase(nombre)) {
				validaciones.add("El NOMBRE es obligatorio");
			}
			
			if ("".equalsIgnoreCase(apellido)) {
				validaciones.add("El APELLIDO es obligatorio");
			}
			
			if ("".equalsIgnoreCase(contrasenia)) {
				validaciones.add("La CONTRASENIA es obligatoria");
			}
			
			if ("".equalsIgnoreCase(edad)) {
				validaciones.add("La EDAD es obligatoria");
			}
			
			if ("".equalsIgnoreCase(dni)) {
				validaciones.add("El DNI es obligatorio");
			}
			
			if (horas == null) {
				validaciones.add("Las horas son obligatorias");
			}
			
			
			if(sexo.equalsIgnoreCase("h")) {
				
				sexo = "Hombre";
				
			} else if (sexo.equalsIgnoreCase("m")) {
				
				sexo = "Mujer";
			}
			
			
			ArrayList<String> horario = new ArrayList<String>();
			
			if (horas != null) {
				for (String seleccion : horas) {
					
					if(seleccion.equalsIgnoreCase("ft")) {
						
						horario.add("Tiempo completo");
						
					} else if(seleccion.equalsIgnoreCase("pt")) {
						
						horario.add("Tiempo parcial");
						
					} else if(seleccion.equalsIgnoreCase("all")) {
						
						horario.add("Todos");
					}
				}
			}
			
			if (estudios.equalsIgnoreCase("u")) {
				estudios = "Universidad";
	        } else if (estudios.equalsIgnoreCase("p")) {
	        	estudios = "Formacion Profesional";
	        } else {
	        	estudios = "Otros";
	        }
			
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellido", apellido);
			request.setAttribute("contrasenia", contrasenia);
			request.setAttribute("edad", edad);
			request.setAttribute("dni", dni);
			request.setAttribute("sexo", sexo);
			request.setAttribute("horas", horario);
			request.setAttribute("estudios", estudios);
			request.setAttribute("comentarios", comentarios);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("mensaje", "Tenemos un error: " + e.getMessage());
			
		} finally {
			
			if (validaciones.isEmpty()) {
				
				request.getRequestDispatcher("formulario-resumen.jsp").forward(request, response);
				
			} else {
				
				request.setAttribute("validaciones", validaciones);
				request.getRequestDispatcher("views/ejemplos/formulario.jsp").forward(request, response);
			}
		}		
	}
}
