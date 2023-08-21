package com.afdm.potafy.controller;

import java.io.IOException;

import com.afdm.potafymodel.Usuario;
import com.afdm.potafymodel.exception.ConexionException;
import com.afdm.potafymodel.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class iniciarSesionServlet
 */
public class iniciarSesionServlet extends HttpServlet {
       
	/**
	 * 
	 */
	private static final long serialVersionUID = -8963724892066129529L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreUsuario = request.getParameter("NombreUsuario");
		String clave = request.getParameter("Clave");
		Fachada fachada = new Fachada();
		try {
			Usuario usuario = fachada.iniciarSesion(nombreUsuario, clave);
			
			if (usuario != null) {
				//request.getSession().setAttribute(clave, usuario);
				request.getSession().setAttribute("Usuario", usuario);
				response.sendRedirect("PrincipalPotaFy.jsp");
			} else {
				request.setAttribute("error", "Datos no encontrados. Si eres nuevo por aquí regístrate clickando en el siguiente enlace");
				request.getRequestDispatcher("IndexPotaFy.jsp").forward(request, response);
			}
		} catch (ConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
