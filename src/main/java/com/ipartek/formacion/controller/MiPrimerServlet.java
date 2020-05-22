package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MiPrimerServlet
 */
@WebServlet("/MiPrimerServlet")
public class MiPrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recibir parametros de la REQUEST
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		
		
		//ademas de parametros podemos obtener informacion del usuario a traves de la REQUEST
		String versionDelNavegador = request.getHeader("user-agent");
		String protocolo = request.getProtocol();
		
		//pintar html como respuesta
		PrintWriter out = response.getWriter();
		out.println("<h1>Soy la respuesta del Servlet</h1>");
		out.println("<p>Hola: " + nombre + "</p>");
		out.println("<p>Tu email es: " + email + "</p>");
		out.println("<p>Protocolo: " + protocolo + "</p>");
		out.println("<p>Navegador: " + versionDelNavegador + "</p>");
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
