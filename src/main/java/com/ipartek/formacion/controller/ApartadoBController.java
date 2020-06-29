package com.ipartek.formacion.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuardarCookiesController
 */
@WebServlet("/apartado-b")
public class ApartadoBController extends HttpServlet {
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
		String userAgent = request.getHeader("user-agent");
		
		//crear una sesion				
		HttpSession session = request.getSession();	
		
		//datos de tiempo	
		LocalDateTime tiempo = LocalDateTime.now();
		String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH:mm"));		
			
		session.setMaxInactiveInterval (60*5); //la sesion se cierra si esta 5 minutos inactiva

		//dar atributos a la sesion
		session.setAttribute("sFecha",formattedDate);
		session.setAttribute("sNombre", nombre);
		session.setAttribute("uAgent", userAgent);
		
		
		// Ir a la vista	
		request.getRequestDispatcher("views/ejemplos/resultadoB.jsp").forward(request, response);
	}
}
