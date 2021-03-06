package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.Usuario;
import com.ipartek.formacion.modelo.UsuarioDAOImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("name");
		String pass = request.getParameter("pass");
		String idioma = request.getParameter("lang");
		
		//guardar cookie de idioma
		Cookie cIdioma = new Cookie("cIdioma", idioma);
		cIdioma.setMaxAge (60*1*60*365*5); //5 años
		//guardar cookie
		response.addCookie(cIdioma);
		
		HttpSession session = request.getSession();
		
		UsuarioDAOImpl dao = UsuarioDAOImpl.getInstance();
		Usuario usuario = dao.existe(nombre, pass);
		
		if (usuario != null) {
			
			session.setMaxInactiveInterval (60*5); //la sesion se cierra si esta 5 minutos inactiva
			session.setAttribute("usuario_login", usuario );
			
			
			request.setAttribute("alerta", new Alerta("success", "Estas dentro"));
			request.getRequestDispatcher("index.jsp").forward(request, response);;
			
		} else {
			
			
			request.setAttribute("alerta", new Alerta("warning", "Credenciales incorrectas"));
			request.getRequestDispatcher("views/ejemplos/login.jsp").forward(request, response);
		}
	}
}