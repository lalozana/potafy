package com.afdm.potafy.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.afdm.potafymodel.Usuario;
import com.afdm.potafymodel.exception.ConexionException;
import com.afdm.potafymodel.fachada.Fachada;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BorrarCancionesServlet
 */
public class BorrarCancionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String txtcancion = request.getParameter("cancion");
		String fichero = request.getParameter("fichero");
		// comprobar si llega el JS al Servlet
		System.out.println("Canción: " + txtcancion);
		
		// convertir "cancion", que en html funciona como String, a int porque desde el DAO idCancion le indicamos que es un número integer
		int idCancion = Integer.parseInt(txtcancion);

		
		Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
		Fachada fachada = new Fachada();
		try {
			boolean cancionParaBorrar = fachada.borrarCancion(idCancion, usuario.getIdUsuario());
			// Creamos el objecto ruta en el cual indicamos la ruta del servidor de la carpeta Canciones
			if(cancionParaBorrar) {
			String ruta = request.getServletContext().getRealPath("")+ "Canciones" + File.separator + fichero;
			File ficheroCancion = new File(ruta);
			boolean deleted = ficheroCancion.delete();
			System.out.println("DELETED: " + deleted);
			}
			//
			response.setContentType("application/json;charset=utf-8");
			PrintWriter salida = response.getWriter();
			salida.write(Boolean.toString(cancionParaBorrar));
			salida.close();
		} catch (ConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
