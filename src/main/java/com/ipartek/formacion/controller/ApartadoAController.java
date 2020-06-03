package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuardarCookiesController
 */
@WebServlet("/apartado-a")
public class ApartadoAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros
		String nombre = request.getParameter("nombre");
		String color = request.getParameter("color");
		String mostrarColor = "";		
		
		switch (color) {
			case "az":
				mostrarColor = "Azul";
				break;
			
			case "ro":
				mostrarColor = "Rojo";
				break;
			
			case "ve":
				mostrarColor = "Verde";
				break;
		}
		
		//crear cookie de color
		Cookie cColor = new Cookie("cColor", mostrarColor);
		cColor.setMaxAge (60*1*60*365*5); //5 años
		
		Cookie cNombre = new Cookie("cNombre", nombre);
		cNombre.setMaxAge (60*1*60*365*5);
		
		
		//guardar cookies
		response.addCookie(cColor);
		response.addCookie(cNombre);
		
		//en vez de request interna con forward
		//request.getRequestDispatcher("resultadoA.jsp").forward(request, response);
		
		//redicreccion como RESPUESTA, el cliente automaticamente hace la 2nd REQUEST a esta URL
		response.sendRedirect("resultadoA.jsp");
	}
}
