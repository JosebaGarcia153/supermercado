package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idioma = "es";
		String mensaje = "";
		
		//recuperar cookie de idioma para mensaje de salida
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			
			if ("cIdioma".equals(c.getName())) { //cookie encontrada
				idioma = c.getValue();
				break;
			}
		}
		
		switch (idioma) {
			case "es":
				mensaje = "Adios";
				break;
				
			case "en":
				mensaje = "Goodbie";
				break;
				
			case "other":
				mensaje = "gergdergder";
				break;
		
		}
		//ATENCION: esto va despues de las cookies para que funcionen
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;

		request.setAttribute("alerta", new Alerta("success", mensaje));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
